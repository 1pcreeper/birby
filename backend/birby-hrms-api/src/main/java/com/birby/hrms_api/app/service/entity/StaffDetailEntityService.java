package com.birby.hrms_api.service.entity;

import com.birby.hrms_api.model.exception.ResourceNotFoundException;
import com.birby.hrms_api.model.entity.StaffDetail;

public interface StaffDetailEntityService {
    StaffDetail findById(String id) throws ResourceNotFoundException;
    StaffDetail save(StaffDetail staffDetail);
}
