package com.birby.hrms_account_api.app.service.manager;

import com.birby.hrms_account_api.app.model.dto.req.StaffUpdateV1ReqDTO;
import com.birby.hrms_account_api.app.model.dto.res.StaffV1ResDTO;

import java.security.Principal;

public interface StaffManagerService {
    StaffV1ResDTO updateStaffV1(String staffId , StaffUpdateV1ReqDTO reqDto);
    StaffV1ResDTO getStaffV1(String staffId);
    StaffV1ResDTO getStaffMyselfV1(Principal principal);
}
