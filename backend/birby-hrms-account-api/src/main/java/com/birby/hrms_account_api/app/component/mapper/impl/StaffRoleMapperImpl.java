package com.birby.hrms_account_api.app.component.mapper.impl;

import com.birby.hrms_account_api.app.model.dto.res.StaffRoleIdsV1ResDTO;
import com.birby.hrms_account_api.app.component.mapper.StaffRoleMapper;
import com.birby.hrms_account_api.app.model.entity.Staff;
import com.birby.hrms_account_api.app.model.entity.StaffRole;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffRoleMapperImpl implements StaffRoleMapper {
    @Override
    public StaffRoleIdsV1ResDTO toStaffRoleIdsResDto(Staff staff, List<StaffRole> staffRoles) {
        return StaffRoleIdsV1ResDTO.builder()
                .roleIds(staffRoles.stream().map(sr->sr.getId().getRoleId()).collect(Collectors.toList()))
                .staffId(staff.getId())
                .build();
    }
}
