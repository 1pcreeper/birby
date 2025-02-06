package com.birby.hrms_resource_api.service.control;

import com.birby.hrms_resource_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Role;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.List;

public interface StaffRoleControlService {
    void setStaffRoles(String staffId, List<String> roleIds)
            throws ResourceNotFoundException, FirebaseAuthException, DatabaseUpdateFailureException;
}
