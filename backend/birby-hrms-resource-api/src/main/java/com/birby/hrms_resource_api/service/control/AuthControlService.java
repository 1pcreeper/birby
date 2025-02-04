package com.birby.hrms_resource_api.service.control;

import com.birby.hrms_resource_api.bo.response.AuthResBo;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;

import java.security.Principal;
import java.util.Map;

public interface AuthControlService {
    AuthResBo getAuthData(Principal principal) throws ResourceNotFoundException;
}
