package com.birby.hrms_api.app.service.entity.impl;

import com.birby.hrms_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_api.app.model.entity.JobType;
import com.birby.hrms_api.app.repository.JobTypeRepository;
import com.birby.hrms_api.app.service.entity.JobTypeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobTypeEntityServiceImpl implements JobTypeEntityService {
    private final JobTypeRepository jobTypeRepository;
    @Autowired
    public JobTypeEntityServiceImpl(JobTypeRepository jobTypeRepository){
        this.jobTypeRepository = jobTypeRepository;
    }
    @Override
    public JobType findById(String id) throws ResourceNotFoundException {
        return jobTypeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("JobTypeId Not Found"));
    }
}
