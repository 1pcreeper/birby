package com.birby.hrms_account_api.service.cli.impl;

import com.birby.hrms_account_api.model.bo.req.RevokeReqCliBo;
import com.birby.hrms_account_api.client.HRMSRevokeClient;
import com.birby.hrms_account_api.model.response.ApiResponse;
import com.birby.hrms_account_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.service.cli.HRMSRevokeCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HRMSRevokeCliServiceImpl implements HRMSRevokeCliService {
    private final HRMSRevokeClient hrmsRevokeClient;
    @Autowired
    public HRMSRevokeCliServiceImpl(HRMSRevokeClient hrmsRevokeClient){
        this.hrmsRevokeClient = hrmsRevokeClient;
    }
    @Override
    public String revoke(RevokeReqCliBo reqCliBo) {
        ApiResponse<String> res = hrmsRevokeClient.revoke(reqCliBo);
        if(!res.isSuccess()){
            throw new DatabaseUpdateFailureException(res.getMessage());
        }
        return res.getData();
    }
}
