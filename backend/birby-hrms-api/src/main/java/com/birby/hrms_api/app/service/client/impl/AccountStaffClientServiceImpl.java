package com.birby.hrms_api.app.service.client.impl;

import com.birby.hrms_api.app.client.AccountStaffClient;
import com.birby.hrms_api.app.model.cto.res.AccountStaffV1ResCTO;
import com.birby.hrms_api.app.model.exception.ClientServiceException;
import com.birby.hrms_api.app.model.response.ApiResponse;
import com.birby.hrms_api.app.service.client.AccountStaffClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountStaffClientServiceImpl implements AccountStaffClientService {
    private final AccountStaffClient accountStaffClient;
    public AccountStaffClientServiceImpl(AccountStaffClient accountStaffClient){
        this.accountStaffClient = accountStaffClient;
    }

    @Override
    public AccountStaffV1ResCTO getStaffV1(String staffId) throws ClientServiceException {
        try{
            ApiResponse<AccountStaffV1ResCTO> resCTOApiResponse = accountStaffClient.getStaff(staffId);
            if(!resCTOApiResponse.isSuccess()){
                throw new RuntimeException(resCTOApiResponse.getMessage());
            }
            return resCTOApiResponse.getData();
        }catch(RuntimeException e){
            log.error(e.getMessage());
            throw new ClientServiceException("get Staff Fail from AccountAPI");
        }
    }
}
