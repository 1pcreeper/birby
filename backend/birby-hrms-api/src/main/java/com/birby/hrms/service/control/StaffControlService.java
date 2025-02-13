package com.birby.hrms.service.control;

import com.birby.hrms.bo.request.StaffReqBo;
import com.birby.hrms.exception.DatabaseUpdateFailureException;
import com.birby.hrms.exception.ResourceUpdateFailureException;
import com.birby.hrms.model.StaffDetail;

public interface StaffControlService {
    StaffDetail createStaffAndStaffDetail(StaffReqBo reqBo)
            throws DatabaseUpdateFailureException, ResourceUpdateFailureException;
}
