package com.birby.hrms_account_api.service.cli;

import com.birby.hrms_account_api.model.bo.req.RevokeReqCliBo;

public interface HRMSRevokeCliService {
    String revoke(RevokeReqCliBo reqCliBo);
}
