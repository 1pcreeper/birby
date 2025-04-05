package com.birby.hrms_account_api.app.service.common;

import com.birby.hrms_account_api.app.model.dto.res.StaffV1ResDTO;
import com.birby.hrms_account_api.app.model.exception.RegisterFailureException;

public interface RegisterService {
    StaffV1ResDTO registerV1(String name, String password, String displayName)
            throws RegisterFailureException;
}
