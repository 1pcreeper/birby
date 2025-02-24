package com.birby.hrms.client;

import com.birby.hrms.model.bo.res.AccountStaffRoleIdsResCliBo;
import com.birby.hrms.model.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name="resourceAuthClient",
        url="${client-config.account-url}"
)
public interface AccountStaffRoleClient {
    @GetMapping("/staff-role/view-uid/{uid}")
    ApiResponse<AccountStaffRoleIdsResCliBo> getStaffRolesByUid(
            @RequestHeader(name = "Authorization")String authorization,
            @PathVariable(name = "uid")String uid
    );
    @GetMapping("/staff-role/view-uid/me")
    ApiResponse<AccountStaffRoleIdsResCliBo> getStaffRolesByUidMyself(
            @RequestHeader(name = "Authorization")String authorization
    );
}
