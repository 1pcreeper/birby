package com.birby.hrms_resource_api.service.manager;

import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Staff;

public interface StaffManagerService {
    Staff findByName(String name) throws ResourceNotFoundException;
    Staff findByUid(String uid) throws ResourceNotFoundException;
    Staff findByEmail(String email) throws ResourceNotFoundException;
    Staff save(Staff staff);
}
