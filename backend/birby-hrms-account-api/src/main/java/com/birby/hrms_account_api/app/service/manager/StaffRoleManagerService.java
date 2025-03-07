package com.birby.hrms_account_api.app.service.manager;

import com.birby.hrms_account_api.app.model.dto.res.StaffRoleIdsResDto;
import com.birby.hrms_account_api.app.model.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.app.model.exception.ResourceNotFoundException;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.List;

public interface StaffRoleManagerService {
    void setStaffRoles(String staffId, List<String> roleIds,String token)
            throws ResourceNotFoundException, FirebaseAuthException, DatabaseUpdateFailureException;
    StaffRoleIdsResDto getStaffRolesByUid(String uid);
}
