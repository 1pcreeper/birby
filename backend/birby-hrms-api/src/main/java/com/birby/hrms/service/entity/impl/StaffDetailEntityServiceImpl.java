package com.birby.hrms.service.entity.impl;

import com.birby.hrms.exception.ResourceNotFoundException;
import com.birby.hrms.model.entity.StaffDetail;
import com.birby.hrms.repository.StaffDetailRepository;
import com.birby.hrms.service.entity.StaffDetailEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffDetailEntityServiceImpl implements StaffDetailEntityService {
    private final StaffDetailRepository staffDetailRepository;
    @Autowired
    public StaffDetailEntityServiceImpl(StaffDetailRepository staffDetailRepository){
        this.staffDetailRepository=staffDetailRepository;
    }
    @Override
    public StaffDetail findById(String id) throws ResourceNotFoundException {
        return staffDetailRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("StaffId Not Found"));
    }

    @Override
    public StaffDetail save(StaffDetail staffDetail) {
        return staffDetailRepository.save(staffDetail);
    }
}
