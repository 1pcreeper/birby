package com.birby.hrms_resource_api.service.entity;

import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Staff;

public interface StaffEntityService {
    Staff findByName(String name) throws ResourceNotFoundException;
    Staff findByUid(String uid) throws ResourceNotFoundException;
    Staff findByEmail(String email) throws ResourceNotFoundException;
    Staff findById(String id) throws ResourceNotFoundException;
    Staff save(Staff staff);
}
