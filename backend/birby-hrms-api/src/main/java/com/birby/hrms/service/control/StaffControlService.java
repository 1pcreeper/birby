package com.birby.hrms.service.control;

import com.birby.hrms.bo.request.StaffCreateReqBo;
import com.birby.hrms.bo.response.StaffCreateResBo;
import com.birby.hrms.exception.DatabaseUpdateFailureException;
import com.birby.hrms.exception.ResourceUpdateFailureException;
import com.birby.hrms.model.StaffDetail;

public interface StaffControlService {
    StaffCreateResBo createStaffAndStaffDetail(StaffCreateReqBo reqBo)
            throws DatabaseUpdateFailureException, ResourceUpdateFailureException;
}
