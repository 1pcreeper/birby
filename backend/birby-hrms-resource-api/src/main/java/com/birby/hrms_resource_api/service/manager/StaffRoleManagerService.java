package com.birby.hrms_resource_api.service.manager;

import com.birby.hrms_resource_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.List;

public interface StaffRoleManagerService {
    void setStaffRoles(String staffId, List<String> roleIds)
            throws ResourceNotFoundException, FirebaseAuthException, DatabaseUpdateFailureException;
}
