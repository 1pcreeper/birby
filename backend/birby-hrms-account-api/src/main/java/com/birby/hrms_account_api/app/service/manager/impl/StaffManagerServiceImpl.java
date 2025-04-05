package com.birby.hrms_account_api.app.service.manager.impl;

import com.birby.hrms_account_api.app.model.dto.req.StaffUpdateV1ReqDTO;
import com.birby.hrms_account_api.app.model.dto.res.StaffV1ResDTO;
import com.birby.hrms_account_api.app.component.mapper.StaffMapper;
import com.birby.hrms_account_api.app.model.entity.Staff;
import com.birby.hrms_account_api.app.service.entity.StaffEntityService;
import com.birby.hrms_account_api.app.service.manager.StaffManagerService;
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
    public StaffV1ResDTO updateStaffV1(String staffId, StaffUpdateV1ReqDTO reqDto) {
        Staff staff = staffEntityService.findById(staffId);
        staff.setDisplayName(reqDto.getDisplayName());
        staffEntityService.save(staff);
        return staffMapper.toStaffResDto(staff);
    }

    @Override
    public StaffV1ResDTO getStaffV1(String staffId) {
        Staff staff = staffEntityService.findById(staffId);
        return staffMapper.toStaffResDto(staff);
    }

    @Override
    public StaffV1ResDTO getStaffMyselfV1(Principal principal) {
        Staff staff = staffEntityService.findByUid(principal.getName());
        return staffMapper.toStaffResDto(staff);
    }
}
