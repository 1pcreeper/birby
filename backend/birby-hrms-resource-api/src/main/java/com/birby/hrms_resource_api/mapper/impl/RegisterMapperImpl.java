package com.birby.hrms_resource_api.mapper.impl;

import com.birby.hrms_resource_api.dto.response.RegisterResDto;
import com.birby.hrms_resource_api.mapper.RegisterMapper;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapperImpl implements RegisterMapper {
    @Override
    public RegisterResDto toRegisterResDto(String uid) {
        return RegisterResDto
                .builder()
                .uid(uid)
                .build();
    }
}
