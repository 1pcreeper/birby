package com.birby.hrms_account_api.component.mapper;

import com.birby.hrms_account_api.model.dto.res.StaffRoleIdsResDto;
import com.birby.hrms_account_api.model.entity.Staff;
import com.birby.hrms_account_api.model.entity.StaffRole;

import java.util.List;

public interface StaffRoleMapper {
    StaffRoleIdsResDto toStaffRoleIdsResDto(Staff staff, List<StaffRole> staffRoles);
}
