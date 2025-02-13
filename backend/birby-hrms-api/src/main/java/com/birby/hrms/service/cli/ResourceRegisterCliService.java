package com.birby.hrms.service.cli;

import com.birby.hrms.bo.request.ResourceRegisterReqCliBo;
import com.birby.hrms.bo.response.ResourceRegisterResCliBo;
import com.birby.hrms.dto.ApiResponse;

public interface ResourceRegisterCliService {
    ApiResponse<ResourceRegisterResCliBo> register(ResourceRegisterReqCliBo reqCliBo,String token);
}
