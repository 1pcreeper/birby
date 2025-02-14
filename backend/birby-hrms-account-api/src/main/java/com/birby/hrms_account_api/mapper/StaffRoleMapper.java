package com.birby.hrms_account_api.mapper;

import com.birby.hrms_account_api.dto.response.StaffRoleIdsResDto;
import com.birby.hrms_account_api.model.Staff;
import com.birby.hrms_account_api.model.StaffRole;

import java.util.List;

public interface StaffRoleMapper {
    StaffRoleIdsResDto toStaffRoleIdsResDto(Staff staff, List<StaffRole> staffRoles);
}
