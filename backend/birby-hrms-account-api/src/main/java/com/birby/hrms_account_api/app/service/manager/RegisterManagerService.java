package com.birby.hrms_account_api.app.service.manager;

import com.birby.hrms_account_api.app.model.dto.res.StaffV1ResDTO;
import com.birby.hrms_account_api.app.model.exception.RegisterFailureException;

public interface RegisterManagerService {
    StaffV1ResDTO registerV1(String name, String password, String displayName)
            throws RegisterFailureException;
}
