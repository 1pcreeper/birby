package com.birby.hrms_account_api.service.manager.impl;

import com.birby.hrms_account_api.model.bo.request.RevokeReqCliBo;
import com.birby.hrms_account_api.model.dto.response.StaffRoleIdsResDto;
import com.birby.hrms_account_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.mapper.StaffRoleMapper;
import com.birby.hrms_account_api.model.entity.Staff;
import com.birby.hrms_account_api.model.entity.StaffRole;
import com.birby.hrms_account_api.service.auth.FirebaseAuthService;
import com.birby.hrms_account_api.service.cli.HRMSRevokeCliService;
import com.birby.hrms_account_api.service.entity.StaffEntityService;
import com.birby.hrms_account_api.service.entity.StaffRoleEntityService;
import com.birby.hrms_account_api.service.common.BloomFilterService;
import com.birby.hrms_account_api.service.manager.StaffRoleManagerService;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffRoleManagerServiceImpl implements StaffRoleManagerService {
    private final StaffRoleEntityService staffRoleEntityService;
    private final FirebaseAuthService firebaseAuthService;
    private final StaffEntityService staffEntityService;
    private final StaffRoleMapper staffRoleMapper;
    private final BloomFilterService bloomFilterService;
    private final HRMSRevokeCliService hrmsRevokeCliService;
    @Autowired
    public StaffRoleManagerServiceImpl(
            StaffRoleEntityService staffRoleEntityService,
            FirebaseAuthService firebaseAuthService,
            StaffEntityService staffEntityService,
            StaffRoleMapper staffRoleMapper,
            BloomFilterService bloomFilterService,
            HRMSRevokeCliService hrmsRevokeCliService
    ) {
        this.staffRoleEntityService = staffRoleEntityService;
        this.firebaseAuthService = firebaseAuthService;
        this.staffEntityService = staffEntityService;
        this.staffRoleMapper = staffRoleMapper;
        this.bloomFilterService = bloomFilterService;
        this.hrmsRevokeCliService = hrmsRevokeCliService;
    }

    @Override
    @Transactional
    public void setStaffRoles(String staffId, List<String> roleIds)
            throws ResourceNotFoundException, FirebaseAuthException , DatabaseUpdateFailureException {
        List<StaffRole> staffRoles = staffRoleEntityService.findByStaffId(staffId);
        staffRoleEntityService.deleteAll(staffRoles);
        for(String roleId : roleIds){
            staffRoleEntityService.insert(staffId,roleId);
        }
        Staff staff = staffEntityService.findById(staffId);
        firebaseAuthService.setRoleClaims(staff.getUid(),roleIds);
        bloomFilterService.addBloom(staff.getUid(),roleIds);
        RevokeReqCliBo revokeReqCliBo =  RevokeReqCliBo.builder()
                .uid(staff.getUid())
                .roleIds(roleIds)
                .build();
       hrmsRevokeCliService.revoke(revokeReqCliBo);
    }

    @Override
    public StaffRoleIdsResDto getStaffRolesByUid(String uid) {
        Staff staff = staffEntityService.findByUid(uid);
        List<StaffRole> staffRoles = staffRoleEntityService.findByStaffId(staff.getId());
        return staffRoleMapper.toStaffRoleIdsResDto(staff,staffRoles);
    }
}
