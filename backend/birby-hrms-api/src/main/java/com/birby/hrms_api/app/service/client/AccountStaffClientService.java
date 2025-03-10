package com.birby.hrms_api.app.service.client;

import com.birby.hrms_api.app.model.clidto.res.AccountStaffResCliDto;
import com.birby.hrms_api.app.model.exception.ClientServiceException;
import com.birby.hrms_api.app.model.response.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;

public interface AccountStaffClientService {
    AccountStaffResCliDto getStaff(String staffId) throws ClientServiceException;
}
