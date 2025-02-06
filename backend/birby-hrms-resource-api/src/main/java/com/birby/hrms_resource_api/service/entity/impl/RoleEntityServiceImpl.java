package com.birby.hrms_resource_api.service.entity.impl;

import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Role;
import com.birby.hrms_resource_api.repository.RoleRepository;
import com.birby.hrms_resource_api.service.entity.RoleEntityService;
import org.springframework.stereotype.Service;

@Service
public class RoleEntityServiceImpl implements RoleEntityService {
    private final RoleRepository roleRepository;
    public RoleEntityServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public Role findById(String id) throws ResourceNotFoundException {
        return roleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("RoleId Not Found"));
    }
}
