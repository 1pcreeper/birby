package com.birby.hrms_account_api.mapper;

import com.birby.hrms_account_api.model.dto.res.StaffResDto;
import com.birby.hrms_account_api.model.entity.Staff;

public interface StaffMapper {
    StaffResDto toStaffResDto(Staff staff);
}
