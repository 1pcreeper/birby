package com.birby.hrms.mapper;

import com.birby.hrms.bo.request.StaffReqBo;
import com.birby.hrms.dto.request.StaffCreateReqDto;
import com.birby.hrms.exception.ValidationException;
import com.birby.hrms.vo.JwtPrincipal;

public interface StaffMapper {
    StaffReqBo toStaffReqBo(StaffCreateReqDto reqDto, JwtPrincipal jwtPrincipal)
            throws ValidationException;
}
