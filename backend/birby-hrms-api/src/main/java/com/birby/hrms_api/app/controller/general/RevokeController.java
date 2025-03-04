package com.birby.hrms_api.app.controller.general;

import com.birby.hrms_api.app.model.response.ApiResponse;
import com.birby.hrms_api.app.model.dto.req.RevokeReqDto;
import com.birby.hrms_api.app.service.manager.BloomFilterManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/revoke")
public class RevokeController {
    private final BloomFilterManagerService bloomFilterManagerService;
    @Autowired
    public RevokeController(BloomFilterManagerService bloomFilterManagerService){
        this.bloomFilterManagerService = bloomFilterManagerService;
    }
    @PostMapping()
    public ApiResponse<String> revoke(@Valid @RequestBody RevokeReqDto reqDto){
        bloomFilterManagerService.addBloom(reqDto.getUid(),reqDto.getRoleIds());
        return ApiResponse.ok(
                "Revoked token",
                ""
        );
    }
}
