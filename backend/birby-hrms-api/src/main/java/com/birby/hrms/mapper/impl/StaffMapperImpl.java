package com.birby.hrms.mapper.impl;

import com.birby.hrms.bo.request.ResourceRegisterReqCliBo;
import com.birby.hrms.bo.request.StaffReqBo;
import com.birby.hrms.dto.request.StaffCreateReqDto;
import com.birby.hrms.exception.ValidationException;
import com.birby.hrms.mapper.StaffMapper;
import com.birby.hrms.model.JobType;
import com.birby.hrms.model.StaffDetail;
import com.birby.hrms.service.entity.JobTypeEntityService;
import com.birby.hrms.util.DateTimeUtil;
import com.birby.hrms.vo.JwtPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StaffMapperImpl implements StaffMapper {
    private final JobTypeEntityService jobTypeEntityService;

    @Autowired
    public StaffMapperImpl(
            JobTypeEntityService jobTypeEntityService
    ) {
        this.jobTypeEntityService = jobTypeEntityService;
    }

    @Override
    public StaffReqBo toStaffReqBo(StaffCreateReqDto reqDto, JwtPrincipal jwtPrincipal)
            throws ValidationException {
        ResourceRegisterReqCliBo reqCliBo = new ResourceRegisterReqCliBo();
        reqCliBo.setName(reqDto.getName());
        reqCliBo.setDisplayName(reqDto.getDisplayName());
        reqCliBo.setPassword(reqDto.getPassword());
        boolean gender = switch (reqDto.getGender()) {
            case "male" -> true;
            case "female" -> false;
            default -> throw new ValidationException("Invalid Gender");
        };
        JobType jobType = jobTypeEntityService.findById(reqDto.getJobTypeId());
        StaffDetail staffDetail = new StaffDetail();
        staffDetail.setGender(gender);
        staffDetail.setBirth(DateTimeUtil.toDate(reqDto.getBirth()));
        staffDetail.setHkPhone(reqDto.getHkPhone());
        staffDetail.setJobType(jobType);
        StaffReqBo staffReqBo = new StaffReqBo();
        staffReqBo.setToken(jwtPrincipal.getToken());
        staffReqBo.setResourceRegisterReqCliBo(reqCliBo);
        staffReqBo.setStaffDetail(staffDetail);
        return staffReqBo;
    }
}
