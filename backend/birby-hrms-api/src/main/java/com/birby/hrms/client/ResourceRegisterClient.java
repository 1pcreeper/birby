package com.birby.hrms.client;

import com.birby.hrms.dto.ApiResponse;
import com.birby.hrms.bo.request.ResourceRegisterReqCliBo;
import com.birby.hrms.bo.response.ResourceRegisterResCliBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name="resourceRegisterCliClient",
        url = "client-config.resource-url"
)
public interface ResourceRegisterClient {
    @PostMapping("/register")
    ApiResponse<ResourceRegisterResCliBo> register(
            @RequestHeader(name = "Authorization")String authorization,
            @RequestBody ResourceRegisterReqCliBo reqBo
    );
}
