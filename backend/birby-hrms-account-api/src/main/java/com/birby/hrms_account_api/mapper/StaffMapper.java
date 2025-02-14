package com.birby.hrms_account_api.mapper;

import com.birby.hrms_account_api.dto.response.StaffResDto;
import com.birby.hrms_account_api.model.Staff;

public interface StaffMapper {
    StaffResDto toStaffResDto(Staff staff);
}
