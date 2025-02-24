package com.birby.hrms_account_api.service.manager;

import com.birby.hrms_account_api.model.dto.request.StaffUpdateReqDto;
import com.birby.hrms_account_api.model.dto.response.StaffResDto;

import java.security.Principal;

public interface StaffManagerService {
    StaffResDto updateStaff(String staffId ,StaffUpdateReqDto reqDto);
    StaffResDto getStaff(String staffId);
    StaffResDto getStaffMyself(Principal principal);
}
