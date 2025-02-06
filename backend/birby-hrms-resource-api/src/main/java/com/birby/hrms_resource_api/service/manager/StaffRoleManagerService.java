package com.birby.hrms_resource_api.service.manager;

import com.birby.hrms_resource_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.StaffRole;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRoleManagerService {

    List<StaffRole> findByStaffId(@Param("staffId") String staffId) throws ResourceNotFoundException;

    int add(String staffId,String roleId) throws DatabaseUpdateFailureException;

    void delete(StaffRole staffRole);

    void deleteAll(List<StaffRole> staffRoles);
}
