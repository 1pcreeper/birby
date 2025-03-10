package com.birby.hrms_account_api.app.component.mapper.impl;

import com.birby.hrms_account_api.app.model.dto.res.StaffResDto;
import com.birby.hrms_account_api.app.component.mapper.StaffMapper;
import com.birby.hrms_account_api.app.model.entity.Staff;
import org.springframework.stereotype.Component;

@Component
public class StaffMapperImpl implements StaffMapper {
    @Override
    public StaffResDto toStaffResDto(Staff staff) {
        return StaffResDto
                .builder()
                .id(staff.getId())
                .uid(staff.getUid())
                .displayName(staff.getDisplayName())
                .name(staff.getName())
                .email(staff.getEmail())
                .build();
    }

}
