package com.birby.hrms_resource_api.service.control;

import com.birby.hrms_resource_api.exception.RegisterFailureException;

public interface RegisterControlService {
    String register(String name,String email,String password) throws RegisterFailureException;
}
