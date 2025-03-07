package com.birby.hrms_api.app.controller.general;

import com.birby.hrms_api.app.model.response.ApiResponse;
import com.birby.hrms_api.app.model.dto.req.RevokeReqDto;
import com.birby.hrms_api.app.service.manager.BloomFilterManagerService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/revoke")
public class RevokeController {
    private final BloomFilterManagerService bloomFilterManagerService;

    @Autowired
    public RevokeController(BloomFilterManagerService bloomFilterManagerService) {
        this.bloomFilterManagerService = bloomFilterManagerService;
    }

    @PostMapping()
    @PermitAll
    public ApiResponse<String> revoke(
            @Valid @RequestBody RevokeReqDto reqDto,
            @RequestHeader(name = "Access") String access
    ) {
        bloomFilterManagerService.addBloom(reqDto.getUid(), reqDto.getRoleIds(),access);
        return ApiResponse.ok(
                "Revoked token",
                ""
        );
    }
}
