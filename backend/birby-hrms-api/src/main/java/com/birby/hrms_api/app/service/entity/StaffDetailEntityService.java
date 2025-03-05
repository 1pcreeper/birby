package com.birby.hrms_api.app.service.entity;

import com.birby.hrms_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_api.app.model.entity.StaffDetail;

public interface StaffDetailEntityService {
    StaffDetail findById(String id) throws ResourceNotFoundException;
    StaffDetail save(StaffDetail staffDetail);
}
