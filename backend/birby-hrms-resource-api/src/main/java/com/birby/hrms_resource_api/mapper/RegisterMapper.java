package com.birby.hrms_resource_api.mapper;

import com.birby.hrms_resource_api.bo.response.RegisterResBo;
import com.birby.hrms_resource_api.dto.response.RegisterResDto;

public interface RegisterMapper {
    RegisterResDto toRegisterResDto(RegisterResBo resBo);
}
