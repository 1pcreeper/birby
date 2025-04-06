package com.birby.hrms_api.app.service.client;

import com.birby.hrms_api.app.model.cto.res.AccountStaffRoleIdsV1ResCTO;

public interface AccountStaffRoleClientService {
    AccountStaffRoleIdsV1ResCTO getStaffRolesByUidV1(String authorization, String uid);
    AccountStaffRoleIdsV1ResCTO getStaffRolesByUidMyselfV1(String authorization);
}
