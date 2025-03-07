package com.birby.hrms_account_api.app.service.client;

import com.birby.hrms_account_api.app.model.clidto.req.RevokeReqCliDto;
import com.birby.hrms_account_api.app.model.exception.BloomFilterTransferException;

public interface HRMSRevokeClientService {
    String revoke(RevokeReqCliDto reqCliDto,String token) throws BloomFilterTransferException;
}
