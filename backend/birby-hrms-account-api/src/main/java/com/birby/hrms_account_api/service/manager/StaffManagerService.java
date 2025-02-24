package com.birby.hrms_account_api.service.manager;

import com.birby.hrms_account_api.model.dto.req.StaffUpdateReqDto;
import com.birby.hrms_account_api.model.dto.res.StaffResDto;

import java.security.Principal;

public interface StaffManagerService {
    StaffResDto updateStaff(String staffId ,StaffUpdateReqDto reqDto);
    StaffResDto getStaff(String staffId);
    StaffResDto getStaffMyself(Principal principal);
}
