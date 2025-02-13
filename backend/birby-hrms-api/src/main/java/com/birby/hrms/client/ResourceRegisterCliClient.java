package com.birby.hrms.client;

import com.birby.hrms.dto.ApiResponse;
import com.birby.hrms.dto.request.ResourceRegisterReqCliDto;
import com.birby.hrms.dto.response.ResourceRegisterResCliDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name="resourceRegisterCliClient",
        url="http://localhost:8080"
)
public interface ResourceRegisterCliClient {
    @PostMapping("/register")
    ApiResponse<ResourceRegisterResCliDto> register(
            @RequestHeader(name = "Authorization")String authorization,
            @RequestBody ResourceRegisterReqCliDto reqDto
    );
}
