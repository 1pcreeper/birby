package com.birby.hrms.mapper;

import com.birby.hrms.bo.request.StaffCreateReqBo;
import com.birby.hrms.dto.request.StaffCreateReqDto;
import com.birby.hrms.dto.response.StaffCreateResDto;
import com.birby.hrms.exception.ValidationException;
import com.birby.hrms.model.StaffDetail;
import com.birby.hrms.vo.JwtPrincipal;

public interface StaffMapper {
    StaffCreateReqBo toStaffCreateReqBo(StaffCreateReqDto reqDto, JwtPrincipal jwtPrincipal)
            throws ValidationException;
    StaffCreateResDto toStaffCreateResDto(StaffDetail staffDetail);
}
