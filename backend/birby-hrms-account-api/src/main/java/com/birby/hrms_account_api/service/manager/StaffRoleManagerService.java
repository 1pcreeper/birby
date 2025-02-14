package com.birby.hrms_account_api.service.manager;

import com.birby.hrms_account_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.model.StaffRole;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.List;

public interface StaffRoleManagerService {
    void setStaffRoles(String staffId, List<String> roleIds)
            throws ResourceNotFoundException, FirebaseAuthException, DatabaseUpdateFailureException;
}
