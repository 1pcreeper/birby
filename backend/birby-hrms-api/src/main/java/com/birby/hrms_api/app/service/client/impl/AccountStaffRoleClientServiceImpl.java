package com.birby.hrms_api.app.service.client.impl;

import com.birby.hrms_api.app.model.cto.res.AccountStaffRoleIdsV1ResCTO;
import com.birby.hrms_api.app.client.AccountStaffRoleClient;
import com.birby.hrms_api.app.model.exception.ClientServiceException;
import com.birby.hrms_api.app.model.exception.UnAuthorizedException;
import com.birby.hrms_api.app.model.response.ApiResponse;
import com.birby.hrms_api.app.service.client.AccountStaffRoleClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountStaffRoleClientServiceImpl implements AccountStaffRoleClientService {
    private final AccountStaffRoleClient accountStaffRoleClient;
    @Autowired
    public AccountStaffRoleClientServiceImpl(AccountStaffRoleClient accountStaffRoleClient){
        this.accountStaffRoleClient = accountStaffRoleClient;
    }
    @Override
    public AccountStaffRoleIdsV1ResCTO getStaffRolesByUidV1(String authorization, String uid) throws ClientServiceException{
        Object object;
        try{
            object = accountStaffRoleClient.getStaffRolesByUidV1(authorization,uid);
        }catch(RuntimeException e){
            log.error(e.getLocalizedMessage());
            throw new UnAuthorizedException(e.getMessage());
        }
        ApiResponse<AccountStaffRoleIdsV1ResCTO> data = (ApiResponse<AccountStaffRoleIdsV1ResCTO>)object;
        return data.getData();
    }

    @Override
    public AccountStaffRoleIdsV1ResCTO getStaffRolesByUidMyselfV1(String authorization) throws ClientServiceException {
        Object object;
        try{
            object = accountStaffRoleClient.getStaffRolesByUidMyselfV1(authorization);
        } catch (RuntimeException e){
            log.error(e.getLocalizedMessage());
            throw new UnAuthorizedException(e.getMessage());
        }
        ApiResponse<AccountStaffRoleIdsV1ResCTO> data = (ApiResponse<AccountStaffRoleIdsV1ResCTO>)object;
        return data.getData();
    }
}
