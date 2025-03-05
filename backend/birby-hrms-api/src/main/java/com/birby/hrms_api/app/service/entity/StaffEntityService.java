package com.birby.hrms_api.service.entity;

import com.birby.hrms_api.model.exception.ResourceNotFoundException;
import com.birby.hrms_api.model.entity.Staff;

public interface StaffEntityService {
    Staff findById(String id) throws ResourceNotFoundException;
    Staff save(Staff staff);
}
