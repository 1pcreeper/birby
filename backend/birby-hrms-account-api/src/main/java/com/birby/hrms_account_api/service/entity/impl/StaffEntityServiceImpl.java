package com.birby.hrms_account_api.service.entity.impl;

import com.birby.hrms_account_api.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.model.entity.Staff;
import com.birby.hrms_account_api.repository.StaffRepository;
import com.birby.hrms_account_api.service.entity.StaffEntityService;
import org.springframework.stereotype.Service;

@Service
public class StaffEntityServiceImpl implements StaffEntityService {
    private final StaffRepository staffRepository;

    public StaffEntityServiceImpl(
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

    @Override
    public Staff findById(String id) throws ResourceNotFoundException {
        return staffRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("StaffId Not Found"));
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }
}
