package com.birby.hrms.client;

import com.birby.hrms.dto.response.ResourceAuthResCliDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name="resourceAuthClient",
        url="http://localhost:8080"
)
public interface ResourceAuthClient {
    @GetMapping("/auth")
    ResourceAuthResCliDto getAuthData(@RequestHeader(name = "Authorization")String authorization);
}
