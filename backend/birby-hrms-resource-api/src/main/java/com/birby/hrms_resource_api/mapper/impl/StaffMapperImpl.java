package com.birby.hrms_resource_api.mapper.impl;

import com.birby.hrms_resource_api.bo.request.StaffUpdateReqBo;
import com.birby.hrms_resource_api.dto.request.StaffUpdateReqDto;
import com.birby.hrms_resource_api.dto.response.StaffUpdateResDto;
import com.birby.hrms_resource_api.mapper.StaffMapper;
import com.birby.hrms_resource_api.model.Staff;
import org.springframework.stereotype.Component;

@Component
public class StaffMapperImpl implements StaffMapper {
    @Override
    public StaffUpdateResDto toStaffUpdateResDto(Staff staff) {
        return StaffUpdateResDto
                .builder()
                .id(staff.getId())
                .uid(staff.getUid())
                .displayName(staff.getDisplayName())
                .name(staff.getName())
                .email(staff.getEmail())
                .build();
    }

    @Override
    public StaffUpdateReqBo toStaffUpdateReqBo(StaffUpdateReqDto reqDto) {
        return StaffUpdateReqBo
                .builder()
                .updateId(reqDto.getUpdateId())
                .displayName(reqDto.getDisplayName())
                .build();
    }

}
