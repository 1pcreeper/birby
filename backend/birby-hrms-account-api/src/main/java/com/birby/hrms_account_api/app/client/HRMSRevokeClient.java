package com.birby.hrms_account_api.app.client;

import com.birby.hrms_account_api.app.model.clidto.req.RevokeReqCliDto;
import com.birby.hrms_account_api.app.model.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name="hrmsRevokeClient",
        url="${client-config.hrms-url}"
)
public interface HRMSRevokeClient {
    @PostMapping("/revoke")
    ApiResponse<String> revoke(@RequestBody RevokeReqCliDto reqCliDto);
}
