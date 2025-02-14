package com.birby.hrms.service.entity;

import com.birby.hrms.exception.ResourceNotFoundException;
import com.birby.hrms.model.Staff;

public interface StaffEntityService {
    Staff findById(String id) throws ResourceNotFoundException;
    Staff save(Staff staff);
}
