package com.birby.hrms_account_api.app.component.mapper;

import com.birby.hrms_account_api.app.model.dto.res.StaffResDto;
import com.birby.hrms_account_api.app.model.entity.Staff;

public interface StaffMapper {
    StaffResDto toStaffResDto(Staff staff);
}
