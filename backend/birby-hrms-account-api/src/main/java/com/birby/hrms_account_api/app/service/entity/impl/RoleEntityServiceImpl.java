package com.birby.hrms_account_api.app.service.entity.impl;

import com.birby.hrms_account_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.app.model.entity.Role;
import com.birby.hrms_account_api.app.repository.RoleRepository;
import com.birby.hrms_account_api.app.service.entity.RoleEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

}
