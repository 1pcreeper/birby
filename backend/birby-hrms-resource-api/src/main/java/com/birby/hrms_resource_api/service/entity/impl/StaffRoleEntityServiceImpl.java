package com.birby.hrms_resource_api.service.entity.impl;

import com.birby.hrms_resource_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.StaffRole;
import com.birby.hrms_resource_api.repository.StaffRoleRepository;
import com.birby.hrms_resource_api.service.entity.StaffRoleEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffRoleEntityServiceImpl implements StaffRoleEntityService {
    private final StaffRoleRepository staffRoleRepository;

    public StaffRoleEntityServiceImpl(
            StaffRoleRepository staffRoleRepository
    ) {
        this.staffRoleRepository = staffRoleRepository;
    }

    @Override
    public List<StaffRole> findByStaffId(String staffId) throws ResourceNotFoundException {
        return staffRoleRepository.findByStaffId(staffId).orElseThrow(()->new ResourceNotFoundException("Staff Not Found"));
    }

    @Override
    public int insert(String staffId, String roleId) throws DatabaseUpdateFailureException {
        try {
            return staffRoleRepository.add(staffId,roleId);
        }catch(RuntimeException e){
            throw new DatabaseUpdateFailureException(e.getMessage());
        }
    }

    @Override
    public void delete(StaffRole staffRole) {
        staffRoleRepository.delete(staffRole);
    }

    @Override
    public void deleteAll(List<StaffRole> staffRoles) {
        staffRoleRepository.deleteAll(staffRoles);
    }

}
