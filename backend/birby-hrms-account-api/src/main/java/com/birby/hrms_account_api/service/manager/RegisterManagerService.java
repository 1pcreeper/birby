package com.birby.hrms_account_api.service.manager;

import com.birby.hrms_account_api.dto.response.StaffResDto;
import com.birby.hrms_account_api.exception.RegisterFailureException;

public interface RegisterManagerService {
    StaffResDto register(String name, String password, String displayName)
            throws RegisterFailureException;
}
