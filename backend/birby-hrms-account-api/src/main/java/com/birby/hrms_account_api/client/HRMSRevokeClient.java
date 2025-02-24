package com.birby.hrms_account_api.client;

import com.birby.hrms_account_api.model.bo.req.RevokeReqCliBo;
import com.birby.hrms_account_api.model.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name="hrmsRevokeClient",
        url="${client-config.hrms-url}"
)
public interface HRMSRevokeClient {
    @PostMapping()
    ApiResponse<String> revoke(@RequestBody RevokeReqCliBo reqCliBo);
}
