package com.birby.hrms_account_api.app.component.mapper;

import com.birby.hrms_account_api.app.model.dto.res.StaffRoleIdsV1ResDTO;
import com.birby.hrms_account_api.app.model.entity.Staff;
import com.birby.hrms_account_api.app.model.entity.StaffRole;

import java.util.List;

public interface StaffRoleMapper {
    StaffRoleIdsV1ResDTO toStaffRoleIdsResDto(Staff staff, List<StaffRole> staffRoles);
}
