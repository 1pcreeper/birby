package com.birby.hrms_account_api.app.service.entity;

import com.birby.hrms_account_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.app.model.entity.Role;

import java.util.List;

public interface RoleEntityService {
    Role findById(String id) throws ResourceNotFoundException;
    List<Role> findAll();
}
