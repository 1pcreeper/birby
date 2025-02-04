package com.birby.hrms_resource_api.service.manager;

import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Role;

import java.util.Optional;

public interface RoleManagerService {
    Role findById(String id) throws ResourceNotFoundException;
}
