package com.birby.hrms_account_api.app.service.client;

import com.birby.hrms_account_api.app.model.clidto.req.RevokeReqCliDto;

public interface HRMSRevokeClientService {
    String revoke(RevokeReqCliDto reqCliBo);
}
