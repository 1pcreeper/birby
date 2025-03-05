package com.birby.hrms_account_api.app.service.manager;

import com.birby.hrms_account_api.app.model.dto.req.StaffUpdateReqDto;
import com.birby.hrms_account_api.app.model.dto.res.StaffResDto;

import java.security.Principal;

public interface StaffManagerService {
    StaffResDto updateStaff(String staffId ,StaffUpdateReqDto reqDto);
    StaffResDto getStaff(String staffId);
    StaffResDto getStaffMyself(Principal principal);
}
