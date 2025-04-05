package com.birby.hrms_account_api.app.component.mapper;

import com.birby.hrms_account_api.app.model.dto.res.StaffV1ResDTO;
import com.birby.hrms_account_api.app.model.entity.Staff;

public interface StaffMapper {
    StaffV1ResDTO toStaffResDto(Staff staff);
}
