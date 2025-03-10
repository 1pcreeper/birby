package com.birby.hrms_account_api.app.service.manager.impl;

import com.birby.hrms_account_api.app.component.properties.ClientProperties;
import com.birby.hrms_account_api.app.model.clidto.req.RevokeReqCliDto;
import com.birby.hrms_account_api.app.model.dto.res.StaffRoleIdsResDto;
import com.birby.hrms_account_api.app.model.exception.BloomFilterTransferException;
import com.birby.hrms_account_api.app.model.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.app.component.mapper.StaffRoleMapper;
import com.birby.hrms_account_api.app.model.entity.Staff;
import com.birby.hrms_account_api.app.model.entity.StaffRole;
import com.birby.hrms_account_api.app.service.auth.FirebaseAuthService;
import com.birby.hrms_account_api.app.service.client.HRMSRevokeClientService;
import com.birby.hrms_account_api.app.service.entity.RoleEntityService;
import com.birby.hrms_account_api.app.service.entity.StaffEntityService;
import com.birby.hrms_account_api.app.service.entity.StaffRoleEntityService;
import com.birby.hrms_account_api.app.service.common.BloomFilterService;
import com.birby.hrms_account_api.app.service.manager.StaffRoleManagerService;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StaffRoleManagerServiceImpl implements StaffRoleManagerService {
    private final StaffRoleEntityService staffRoleEntityService;
    private final FirebaseAuthService firebaseAuthService;
    private final StaffEntityService staffEntityService;
    private final StaffRoleMapper staffRoleMapper;
    private final BloomFilterService bloomFilterService;
    private final HRMSRevokeClientService hrmsRevokeClientService;
    private final RoleEntityService roleEntityService;
    @Autowired
    public StaffRoleManagerServiceImpl(
            StaffRoleEntityService staffRoleEntityService,
            FirebaseAuthService firebaseAuthService,
            StaffEntityService staffEntityService,
            StaffRoleMapper staffRoleMapper,
            BloomFilterService bloomFilterService,
            HRMSRevokeClientService hrmsRevokeClientService,
            RoleEntityService roleEntityService
    ) {
        this.staffRoleEntityService = staffRoleEntityService;
        this.firebaseAuthService = firebaseAuthService;
        this.staffEntityService = staffEntityService;
        this.staffRoleMapper = staffRoleMapper;
        this.bloomFilterService = bloomFilterService;
        this.hrmsRevokeClientService = hrmsRevokeClientService;
        this.roleEntityService = roleEntityService;
    }

    @Override
    @Transactional
    public void setStaffRoles(String staffId, List<String> roleIds,String token)
            throws ResourceNotFoundException, FirebaseAuthException , DatabaseUpdateFailureException {
        Staff staff = staffEntityService.findById(staffId);
        List<StaffRole> staffRoles = staffRoleEntityService.findByStaffId(staff.getId());
        List<String> currentRoleIds = staffRoles.stream().map(sr->sr.getRole().getId()).collect(Collectors.toList());
        System.out.println(currentRoleIds);
        staffRoleEntityService.deleteAll(staffRoles);
        for(String roleId : roleIds){
            roleEntityService.findById(roleId);
            staffRoleEntityService.insert(staff.getId(),roleId);
        }
        firebaseAuthService.setRoleClaims(staff.getUid(),roleIds);
        bloomFilterService.addBloom(
                staff.getUid(),
                currentRoleIds
        );
        RevokeReqCliDto revokeReqCliDto =  RevokeReqCliDto.builder()
                .uid(staff.getUid())
                .roleIds(currentRoleIds)
                .build();
        try{
           hrmsRevokeClientService.revoke(revokeReqCliDto,token);
       } catch (BloomFilterTransferException e) {
            log.error("HRMS Update Bloom Failure");
        }
    }

    @Override
    public StaffRoleIdsResDto getStaffRolesByUid(String uid) {
        Staff staff = staffEntityService.findByUid(uid);
        List<StaffRole> staffRoles = staffRoleEntityService.findByStaffId(staff.getId());
        return staffRoleMapper.toStaffRoleIdsResDto(staff,staffRoles);
    }
}
