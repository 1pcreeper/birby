package com.birby.hrms_resource_api.service.manager.impl;

import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Role;
import com.birby.hrms_resource_api.repository.RoleRepository;
import com.birby.hrms_resource_api.service.manager.RoleManagerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleManagerServiceImpl implements RoleManagerService {
    private final RoleRepository roleRepository;
    public RoleManagerServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public Role findById(String id) throws ResourceNotFoundException {
        return roleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("RoleId Not Found"));
    }
}
