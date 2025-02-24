package com.birby.hrms_account_api.service.manager;

import com.birby.hrms_account_api.model.dto.response.StaffRoleIdsResDto;
import com.birby.hrms_account_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.exception.ResourceNotFoundException;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.List;

public interface StaffRoleManagerService {
    void setStaffRoles(String staffId, List<String> roleIds)
            throws ResourceNotFoundException, FirebaseAuthException, DatabaseUpdateFailureException;
    StaffRoleIdsResDto getStaffRolesByUid(String uid);
}
