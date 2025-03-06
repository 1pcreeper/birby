package com.birby.hrms_account_api.app.service.manager.impl;

import com.birby.hrms_account_api.app.model.clidto.req.RevokeReqCliDto;
import com.birby.hrms_account_api.app.model.dto.res.StaffRoleIdsResDto;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public void setStaffRoles(String staffId, List<String> roleIds)
            throws ResourceNotFoundException, FirebaseAuthException , DatabaseUpdateFailureException {
        List<StaffRole> staffRoles = staffRoleEntityService.findByStaffId(staffId);
        staffRoleEntityService.deleteAll(staffRoles);
        for(String roleId : roleIds){
            roleEntityService.findById(roleId);
            staffRoleEntityService.insert(staffId,roleId);
        }
        Staff staff = staffEntityService.findById(staffId);
        firebaseAuthService.setRoleClaims(staff.getUid(),roleIds);
        bloomFilterService.addBloom(staff.getUid(),roleIds);
        RevokeReqCliDto revokeReqCliDto =  RevokeReqCliDto.builder()
                .uid(staff.getUid())
                .roleIds(roleIds)
                .build();
       hrmsRevokeClientService.revoke(revokeReqCliDto);
    }

    @Override
    public StaffRoleIdsResDto getStaffRolesByUid(String uid) {
        Staff staff = staffEntityService.findByUid(uid);
        List<StaffRole> staffRoles = staffRoleEntityService.findByStaffId(staff.getId());
        return staffRoleMapper.toStaffRoleIdsResDto(staff,staffRoles);
    }
}
