package com.birby.hrms_account_api.client;

import com.birby.hrms_account_api.model.bo.request.RevokeReqCliBo;
import com.birby.hrms_account_api.model.dto.ApiResponse;
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
