package com.birby.hrms_api.app.service.client;

import com.birby.hrms_api.app.model.clidto.res.AccountStaffRoleIdsResCliDto;

public interface AccountStaffRoleClientService {
    AccountStaffRoleIdsResCliDto getStaffRolesByUid(String authorization, String uid);
    AccountStaffRoleIdsResCliDto getStaffRolesByUidMyself(String authorization);
}
