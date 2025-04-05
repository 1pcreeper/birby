package com.birby.hrms_account_api.app.component.mapper.impl;

import com.birby.hrms_account_api.app.model.dto.res.StaffV1ResDTO;
import com.birby.hrms_account_api.app.component.mapper.StaffMapper;
import com.birby.hrms_account_api.app.model.entity.Staff;
import org.springframework.stereotype.Component;

@Component
public class StaffMapperImpl implements StaffMapper {
    @Override
    public StaffV1ResDTO toStaffResDto(Staff staff) {
        return StaffV1ResDTO
                .builder()
                .id(staff.getId())
                .uid(staff.getUid())
                .displayName(staff.getDisplayName())
                .name(staff.getName())
                .email(staff.getEmail())
                .build();
    }

}
