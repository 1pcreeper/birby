package com.birby.hrms_resource_api.service.manager.impl;

import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.StaffRole;
import com.birby.hrms_resource_api.repository.StaffRoleRepository;
import com.birby.hrms_resource_api.service.manager.StaffRoleManagerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffRoleManagerServiceImpl implements StaffRoleManagerService {
    private final StaffRoleRepository staffRoleRepository;

    public StaffRoleManagerServiceImpl(
            StaffRoleRepository staffRoleRepository
    ) {
        this.staffRoleRepository = staffRoleRepository;
    }

    @Override
    public List<StaffRole> findByStaffId(String staffId) throws ResourceNotFoundException {
        return staffRoleRepository.findByStaffId(staffId).orElseThrow(()->new ResourceNotFoundException("Staff Not Found"));
    }

    @Override
    public int add(String staffId, String roleId) {
        return staffRoleRepository.add(staffId,roleId);
    }
}
