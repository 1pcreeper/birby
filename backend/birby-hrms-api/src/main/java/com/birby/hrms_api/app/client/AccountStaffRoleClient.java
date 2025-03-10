package com.birby.hrms_api.app.client;

import com.birby.hrms_api.app.model.clidto.res.AccountStaffRoleIdsResCliDto;
import com.birby.hrms_api.app.model.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name="accountStaffRoleClient",
        url="${client-config.account-url}"
)
public interface AccountStaffRoleClient {
    @GetMapping("/staff-role/view-uid/{uid}")
    ApiResponse<AccountStaffRoleIdsResCliDto> getStaffRolesByUid(
            @RequestHeader(name = "Authorization")String authorization,
            @PathVariable(name = "uid")String uid
    );
    @GetMapping("/staff-role/view-uid/me")
    ApiResponse<AccountStaffRoleIdsResCliDto> getStaffRolesByUidMyself(
            @RequestHeader(name = "Authorization")String authorization
    );
}
