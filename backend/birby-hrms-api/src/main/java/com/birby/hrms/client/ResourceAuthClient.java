package com.birby.hrms.client;

import com.birby.hrms.bo.response.ResourceAuthResCliBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name="resourceAuthClient",
        url="${client-config.resource-url}"
)
public interface ResourceAuthClient {
    @GetMapping("/auth")
    ResourceAuthResCliBo getAuthData(@RequestHeader(name = "Authorization")String authorization);
}
