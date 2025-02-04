package com.birby.hrms_resource_api.service.control;

import com.birby.hrms_resource_api.bo.response.RegisterResBo;
import com.birby.hrms_resource_api.exception.RegisterFailureException;

public interface RegisterControlService {
    RegisterResBo register(String name, String email, String password) throws RegisterFailureException;
}
