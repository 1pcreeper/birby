package com.birby.hrms_account_api.app.service.manager;

import com.birby.hrms_account_api.app.model.dto.res.StaffResDto;
import com.birby.hrms_account_api.app.model.exception.RegisterFailureException;

public interface RegisterManagerService {
    StaffResDto register(String name, String password, String displayName)
            throws RegisterFailureException;
}
