package com.birby.hrms_account_api.mapper.impl;

import com.birby.hrms_account_api.model.dto.res.StaffResDto;
import com.birby.hrms_account_api.mapper.StaffMapper;
import com.birby.hrms_account_api.model.entity.Staff;
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
