package com.birby.hrms_account_api.component.mapper.impl;

import com.birby.hrms_account_api.model.dto.res.StaffRoleIdsResDto;
import com.birby.hrms_account_api.component.mapper.StaffRoleMapper;
import com.birby.hrms_account_api.model.entity.Staff;
import com.birby.hrms_account_api.model.entity.StaffRole;
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
