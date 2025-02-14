package com.birby.hrms.service.entity;

import com.birby.hrms.exception.ResourceNotFoundException;
import com.birby.hrms.model.StaffDetail;

public interface StaffDetailEntityService {
    StaffDetail findById(String id) throws ResourceNotFoundException;
    StaffDetail save(StaffDetail staffDetail);
}
