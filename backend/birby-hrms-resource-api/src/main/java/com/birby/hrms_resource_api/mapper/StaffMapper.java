package com.birby.hrms_resource_api.mapper;

import com.birby.hrms_resource_api.bo.request.StaffUpdateReqBo;
import com.birby.hrms_resource_api.dto.request.StaffUpdateReqDto;
import com.birby.hrms_resource_api.dto.response.StaffUpdateResDto;
import com.birby.hrms_resource_api.model.Staff;

public interface StaffMapper {
    StaffUpdateResDto toStaffUpdateResDto(Staff staff);
    StaffUpdateReqBo toStaffUpdateReqBo(StaffUpdateReqDto reqDto);
}
