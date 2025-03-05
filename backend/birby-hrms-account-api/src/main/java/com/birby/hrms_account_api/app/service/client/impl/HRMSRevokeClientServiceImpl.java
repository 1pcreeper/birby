package com.birby.hrms_account_api.app.service.client.impl;

import com.birby.hrms_account_api.app.model.clidto.req.RevokeReqCliDto;
import com.birby.hrms_account_api.app.client.HRMSRevokeClient;
import com.birby.hrms_account_api.app.model.response.ApiResponse;
import com.birby.hrms_account_api.app.model.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.app.service.client.HRMSRevokeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HRMSRevokeClientServiceImpl implements HRMSRevokeClientService {
    private final HRMSRevokeClient hrmsRevokeClient;
    @Autowired
    public HRMSRevokeClientServiceImpl(HRMSRevokeClient hrmsRevokeClient){
        this.hrmsRevokeClient = hrmsRevokeClient;
    }
    @Override
    public String revoke(RevokeReqCliDto reqCliBo) {
        ApiResponse<String> res = hrmsRevokeClient.revoke(reqCliBo);
        if(!res.isSuccess()){
            throw new DatabaseUpdateFailureException(res.getMessage());
        }
        return res.getData();
    }
}
