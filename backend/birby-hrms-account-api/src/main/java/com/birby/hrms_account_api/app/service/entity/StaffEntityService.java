package com.birby.hrms_account_api.app.service.entity;

import com.birby.hrms_account_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.app.model.entity.Staff;

public interface StaffEntityService {
    Staff findByName(String name) throws ResourceNotFoundException;
    Staff findByUid(String uid) throws ResourceNotFoundException;
    Staff findByEmail(String email) throws ResourceNotFoundException;
    Staff findById(String id) throws ResourceNotFoundException;
    Staff save(Staff staff);
}
