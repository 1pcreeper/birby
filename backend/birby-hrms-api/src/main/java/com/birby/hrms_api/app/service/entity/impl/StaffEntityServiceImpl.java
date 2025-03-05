package com.birby.hrms_api.app.service.entity.impl;

import com.birby.hrms_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_api.app.model.entity.Staff;
import com.birby.hrms_api.app.repository.StaffRepository;
import com.birby.hrms_api.app.service.entity.StaffEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffEntityServiceImpl implements StaffEntityService {
    private final StaffRepository staffRepository;
    @Autowired
    public StaffEntityServiceImpl(StaffRepository staffRepository){
        this.staffRepository=staffRepository;
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
