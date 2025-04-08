package com.birby.hrms_api.app.client;

import com.birby.hrms_api.app.model.cto.res.AccountStaffRoleIdsV1ResCTO;
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
    @GetMapping("/v1/staff-role/view-uid/{uid}")
    ApiResponse<AccountStaffRoleIdsV1ResCTO> getStaffRolesByUidV1(
            @RequestHeader(name = "Authorization")String authorization,
            @PathVariable(name = "uid")String uid
    );
    @GetMapping("/v1/staff-role/view-uid/me")
    ApiResponse<AccountStaffRoleIdsV1ResCTO> getStaffRolesByUidMyselfV1(
            @RequestHeader(name = "Authorization")String authorization
    );
}
