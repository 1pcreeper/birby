package com.birby.hrms_resource_api.mapper.impl;

import com.birby.hrms_resource_api.bo.response.RegisterResBo;
import com.birby.hrms_resource_api.dto.response.RegisterResDto;
import com.birby.hrms_resource_api.mapper.RegisterMapper;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapperImpl implements RegisterMapper {
    @Override
    public RegisterResDto toRegisterResDto(RegisterResBo resBo) {
        return RegisterResDto
                .builder()
                .uid(resBo.getUid())
                .staffId(resBo.getStaffId())
                .build();
    }
}
