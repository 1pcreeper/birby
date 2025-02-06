package com.birby.hrms_resource_api.service.manager.impl;

import com.birby.hrms_resource_api.bo.request.StaffUpdateReqBo;
import com.birby.hrms_resource_api.model.Staff;
import com.birby.hrms_resource_api.service.entity.StaffEntityService;
import com.birby.hrms_resource_api.service.manager.StaffManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffManagerServiceImpl implements StaffManagerService {
    private final StaffEntityService staffEntityService;
    @Autowired
    public StaffManagerServiceImpl(StaffEntityService staffEntityService) {
        this.staffEntityService = staffEntityService;
    }
    @Override
    public Staff updateStaff(StaffUpdateReqBo reqBo) {
        Staff staff = staffEntityService.findById(reqBo.getUpdateId());
        staff.setDisplayName(reqBo.getDisplayName());
        return staffEntityService.save(staff);
    }
}
