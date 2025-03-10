package com.birby.hrms_api.app.client;

import com.birby.hrms_api.app.model.clidto.res.AccountStaffResCliDto;
import com.birby.hrms_api.app.model.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name="accountStaffClient",
        url="${client-config.account-url}"
)
public interface AccountStaffClient {
    ApiResponse<AccountStaffResCliDto> getStaff(@PathVariable(name="id")String staffId);
}
