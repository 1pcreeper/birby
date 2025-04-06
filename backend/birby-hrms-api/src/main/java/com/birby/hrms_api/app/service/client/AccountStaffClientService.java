package com.birby.hrms_api.app.service.client;

import com.birby.hrms_api.app.model.cto.res.AccountStaffV1ResCTO;
import com.birby.hrms_api.app.model.exception.ClientServiceException;

public interface AccountStaffClientService {
    AccountStaffV1ResCTO getStaffV1(String staffId) throws ClientServiceException;
}
