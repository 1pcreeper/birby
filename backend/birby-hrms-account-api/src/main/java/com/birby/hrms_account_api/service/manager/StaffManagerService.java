package com.birby.hrms_account_api.service.manager;

import com.birby.hrms_account_api.dto.request.StaffUpdateReqDto;
import com.birby.hrms_account_api.dto.response.StaffResDto;
import com.birby.hrms_account_api.model.Staff;

import java.security.Principal;

public interface StaffManagerService {
    StaffResDto updateStaff(String staffId ,StaffUpdateReqDto reqDto);
    StaffResDto getStaff(String staffId);
    StaffResDto getStaffMyself(Principal principal);
}
