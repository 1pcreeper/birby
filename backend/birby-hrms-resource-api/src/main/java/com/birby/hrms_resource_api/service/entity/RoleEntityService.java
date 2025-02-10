package com.birby.hrms_resource_api.service.entity;

import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Role;

import java.util.List;

public interface RoleEntityService {
    Role findById(String id) throws ResourceNotFoundException;
    List<Role> findAll();
}
