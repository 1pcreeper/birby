package com.birby.hrms_api.app.service.client.impl;

import com.birby.hrms_api.app.client.AccountStaffClient;
import com.birby.hrms_api.app.model.clidto.res.AccountStaffResCliDto;
import com.birby.hrms_api.app.model.exception.ClientServiceException;
import com.birby.hrms_api.app.model.response.ApiResponse;
import com.birby.hrms_api.app.service.client.AccountStaffClientService;
import feign.FeignException;
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
    public AccountStaffResCliDto getStaff(String staffId) throws ClientServiceException {
        try{
            ApiResponse<AccountStaffResCliDto> resCliDtoApiResponse = accountStaffClient.getStaff(staffId);
            if(!resCliDtoApiResponse.isSuccess()){
                throw new RuntimeException(resCliDtoApiResponse.getMessage());
            }
            return resCliDtoApiResponse.getData();
        }catch(RuntimeException e){
            log.error(e.getMessage());
            throw new ClientServiceException("get Staff Fail from AccountAPI");
        }
    }
}
