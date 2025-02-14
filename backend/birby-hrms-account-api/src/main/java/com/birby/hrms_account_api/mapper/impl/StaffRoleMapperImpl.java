package com.birby.hrms_account_api.mapper.impl;

import com.birby.hrms_account_api.dto.response.StaffRoleIdsResDto;
import com.birby.hrms_account_api.mapper.StaffRoleMapper;
import com.birby.hrms_account_api.model.Staff;
import com.birby.hrms_account_api.model.StaffRole;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffRoleMapperImpl implements StaffRoleMapper {
    @Override
    public StaffRoleIdsResDto toStaffRoleIdsResDto(Staff staff, List<StaffRole> staffRoles) {
        return StaffRoleIdsResDto.builder()
                .roleIds(staffRoles.stream().map(sr->sr.getId().getRoleId()).collect(Collectors.toList()))
                .staffId(staff.getId())
                .build();
    }
}
