package com.birby.hrms_account_api.service.manager.impl;

import com.birby.hrms_account_api.dto.response.StaffRoleIdsResDto;
import com.birby.hrms_account_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.mapper.StaffRoleMapper;
import com.birby.hrms_account_api.model.Staff;
import com.birby.hrms_account_api.model.StaffRole;
import com.birby.hrms_account_api.service.auth.FirebaseAuthService;
import com.birby.hrms_account_api.service.entity.StaffEntityService;
import com.birby.hrms_account_api.service.entity.StaffRoleEntityService;
import com.birby.hrms_account_api.service.manager.StaffRoleManagerService;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffRoleManagerServiceImpl implements StaffRoleManagerService {
    private final StaffRoleEntityService staffRoleEntityService;
    private final FirebaseAuthService firebaseAuthService;
    private final StaffEntityService staffEntityService;
    private final StaffRoleMapper staffRoleMapper;
    public StaffRoleManagerServiceImpl(
            StaffRoleEntityService staffRoleEntityService,
            FirebaseAuthService firebaseAuthService,
            StaffEntityService staffEntityService,
            StaffRoleMapper staffRoleMapper
    ) {
        this.staffRoleEntityService = staffRoleEntityService;
        this.firebaseAuthService = firebaseAuthService;
        this.staffEntityService = staffEntityService;
        this.staffRoleMapper = staffRoleMapper;
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
    }

    @Override
    public StaffRoleIdsResDto getStaffRolesByUid(String uid) {
        Staff staff = staffEntityService.findByUid(uid);
        List<StaffRole> staffRoles = staffRoleEntityService.findByStaffId(staff.getId());
        return staffRoleMapper.toStaffRoleIdsResDto(staff,staffRoles);
    }
}
