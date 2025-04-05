package com.birby.hrms_account_api.app.service.common;

import com.birby.hrms_account_api.app.model.dto.res.StaffRoleIdsV1ResDTO;
import com.birby.hrms_account_api.app.model.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.app.model.exception.ResourceNotFoundException;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.List;

public interface StaffRoleService {
    void setStaffRolesV1(String staffId, List<String> roleIds,String token)
            throws ResourceNotFoundException, FirebaseAuthException, DatabaseUpdateFailureException;
    StaffRoleIdsV1ResDTO getStaffRolesByUidV1(String uid);
}
