package com.birby.hrms.service.cli;

import com.birby.hrms.bo.response.AccountStaffRoleIdsResCliBo;

public interface AccountStaffRoleCliService {
    AccountStaffRoleIdsResCliBo getStaffRolesByUid(String authorization,String uid);
    AccountStaffRoleIdsResCliBo getStaffRolesByUidMyself(String authorization);
}
