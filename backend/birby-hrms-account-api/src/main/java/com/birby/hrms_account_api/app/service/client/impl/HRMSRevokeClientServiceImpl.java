package com.birby.hrms_account_api.app.service.client.impl;

import com.birby.hrms_account_api.app.component.properties.ClientProperties;
import com.birby.hrms_account_api.app.model.clidto.req.RevokeReqCliDto;
import com.birby.hrms_account_api.app.client.HRMSRevokeClient;
import com.birby.hrms_account_api.app.model.exception.BloomFilterTransferException;
import com.birby.hrms_account_api.app.model.response.ApiResponse;
import com.birby.hrms_account_api.app.model.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.app.service.client.HRMSRevokeClientService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HRMSRevokeClientServiceImpl implements HRMSRevokeClientService {
    private final HRMSRevokeClient hrmsRevokeClient;
    private final ClientProperties clientProperties;
    @Autowired
    public HRMSRevokeClientServiceImpl(
            HRMSRevokeClient hrmsRevokeClient,
            ClientProperties clientProperties
    ){
        this.hrmsRevokeClient = hrmsRevokeClient;
        this.clientProperties = clientProperties;
    }
    @Override
    public String revoke(RevokeReqCliDto reqCliDto,String token) throws BloomFilterTransferException {
        ApiResponse<String> res;
        try{
            res = hrmsRevokeClient.revoke(reqCliDto,clientProperties.getHrmsApi(),token);
        } catch (FeignException e) {
            log.error(e.getMessage());
            throw new BloomFilterTransferException("Bloom Update to HRMS Failure");
        }
        if(!res.isSuccess()){
            throw new BloomFilterTransferException(res.getMessage());
        }
        return res.getData();
    }
}
