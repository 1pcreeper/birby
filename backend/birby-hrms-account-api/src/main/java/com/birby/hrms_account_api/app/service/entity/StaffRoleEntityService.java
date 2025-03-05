package com.birby.hrms_account_api.service.entity;

import com.birby.hrms_account_api.model.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.model.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.model.entity.StaffRole;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRoleEntityService {

    List<StaffRole> findByStaffId(@Param("staffId") String staffId) throws ResourceNotFoundException;

    int insert(String staffId, String roleId) throws DatabaseUpdateFailureException;

    void delete(StaffRole staffRole);

    void deleteAll(List<StaffRole> staffRoles);
}
