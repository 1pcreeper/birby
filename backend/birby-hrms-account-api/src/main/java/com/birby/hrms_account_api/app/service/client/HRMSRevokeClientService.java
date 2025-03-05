package com.birby.hrms_account_api.service.client;

import com.birby.hrms_account_api.model.clidto.req.RevokeReqCliDto;

public interface HRMSRevokeClientService {
    String revoke(RevokeReqCliDto reqCliBo);
}
