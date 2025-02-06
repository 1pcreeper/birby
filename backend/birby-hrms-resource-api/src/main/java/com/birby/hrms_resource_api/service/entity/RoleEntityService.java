package com.birby.hrms_resource_api.service.entity;

import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Role;

public interface RoleEntityService {
    Role findById(String id) throws ResourceNotFoundException;
}
