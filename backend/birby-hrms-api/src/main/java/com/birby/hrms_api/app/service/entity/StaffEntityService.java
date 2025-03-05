package com.birby.hrms_api.app.service.entity;

import com.birby.hrms_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_api.app.model.entity.Staff;

public interface StaffEntityService {
    Staff findById(String id) throws ResourceNotFoundException;
    Staff save(Staff staff);
}
