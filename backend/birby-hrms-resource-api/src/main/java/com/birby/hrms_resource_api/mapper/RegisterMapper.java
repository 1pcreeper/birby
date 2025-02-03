package com.birby.hrms_resource_api.mapper;

import com.birby.hrms_resource_api.dto.response.RegisterResDto;

public interface RegisterMapper {
    RegisterResDto toRegisterResDto(String uid);
}
