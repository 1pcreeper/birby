package com.birby.hrms_resource_api.service.manager.impl;

import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Staff;
import com.birby.hrms_resource_api.repository.StaffRepository;
import com.birby.hrms_resource_api.service.manager.StaffManagerService;
import org.springframework.stereotype.Service;

@Service
public class StaffManagerServiceImpl implements StaffManagerService {
    private final StaffRepository staffRepository;

    public StaffManagerServiceImpl(
            StaffRepository staffRepository
    ) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff findByName(String name) throws ResourceNotFoundException {
        return staffRepository.findByName(name).orElseThrow(()->new ResourceNotFoundException("Name Not Found"));
    }

    @Override
    public Staff findByUid(String uid) throws ResourceNotFoundException {
        return staffRepository.findByUid(uid).orElseThrow(()->new ResourceNotFoundException("Uid Not Found"));
    }

    @Override
    public Staff findByEmail(String email) throws ResourceNotFoundException {
        return staffRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("Email Not Found"));
    }
}
