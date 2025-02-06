package com.birby.hrms_resource_api.service.manager;

import com.birby.hrms_resource_api.bo.request.StaffUpdateReqBo;
import com.birby.hrms_resource_api.model.Staff;

public interface StaffManagerService {
    Staff updateStaff(StaffUpdateReqBo reqBo);
}
