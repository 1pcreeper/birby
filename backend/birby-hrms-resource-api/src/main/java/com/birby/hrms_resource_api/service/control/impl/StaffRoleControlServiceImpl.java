package com.birby.hrms_resource_api.service.control.impl;

import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Role;
import com.birby.hrms_resource_api.model.Staff;
import com.birby.hrms_resource_api.model.StaffRole;
import com.birby.hrms_resource_api.service.auth.FirebaseAuthService;
import com.birby.hrms_resource_api.service.control.StaffRoleControlService;
import com.birby.hrms_resource_api.service.manager.RoleManagerService;
import com.birby.hrms_resource_api.service.manager.StaffManagerService;
import com.birby.hrms_resource_api.service.manager.StaffRoleManagerService;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffRoleControlServiceImpl implements StaffRoleControlService {
    private final StaffRoleManagerService staffRoleManagerService;
    private final FirebaseAuthService firebaseAuthService;
    private final StaffManagerService staffManagerService;
    public StaffRoleControlServiceImpl(
            StaffRoleManagerService staffRoleManagerService,
            FirebaseAuthService firebaseAuthService,
            StaffManagerService staffManagerService
    ) {
        this.staffRoleManagerService = staffRoleManagerService;
        this.firebaseAuthService = firebaseAuthService;
        this.staffManagerService = staffManagerService;
    }

    @Override
    public void setStaffRoles(String staffId, List<String> roleIds) throws ResourceNotFoundException, FirebaseAuthException {
        List<StaffRole> staffRoles = staffRoleManagerService.findByStaffId(staffId);
        staffRoleManagerService.deleteAll(staffRoles);
        for(String roleId : roleIds){
            staffRoleManagerService.add(staffId,roleId);
        }
        Staff staff = staffManagerService.findById(staffId);
        firebaseAuthService.setRoleClaims(staff.getUid(),roleIds);
    }
}
