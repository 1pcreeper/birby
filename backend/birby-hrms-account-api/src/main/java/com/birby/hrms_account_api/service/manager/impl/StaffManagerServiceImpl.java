package com.birby.hrms_account_api.service.manager.impl;

import com.birby.hrms_account_api.model.dto.request.StaffUpdateReqDto;
import com.birby.hrms_account_api.model.dto.response.StaffResDto;
import com.birby.hrms_account_api.mapper.StaffMapper;
import com.birby.hrms_account_api.model.entity.Staff;
import com.birby.hrms_account_api.service.entity.StaffEntityService;
import com.birby.hrms_account_api.service.manager.StaffManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class StaffManagerServiceImpl implements StaffManagerService {
    private final StaffEntityService staffEntityService;
    private final StaffMapper staffMapper;
    @Autowired
    public StaffManagerServiceImpl(StaffEntityService staffEntityService, StaffMapper staffMapper) {
        this.staffEntityService = staffEntityService;
        this.staffMapper = staffMapper;
    }
    @Override
    public StaffResDto updateStaff(String staffId,StaffUpdateReqDto reqDto) {
        Staff staff = staffEntityService.findById(staffId);
        staff.setDisplayName(reqDto.getDisplayName());
        staffEntityService.save(staff);
        return staffMapper.toStaffResDto(staff);
    }

    @Override
    public StaffResDto getStaff(String staffId) {
        Staff staff = staffEntityService.findById(staffId);
        return staffMapper.toStaffResDto(staff);
    }

    @Override
    public StaffResDto getStaffMyself(Principal principal) {
        Staff staff = staffEntityService.findByUid(principal.getName());
        return staffMapper.toStaffResDto(staff);
    }
}
