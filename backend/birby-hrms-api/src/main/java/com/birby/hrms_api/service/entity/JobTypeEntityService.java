package com.birby.hrms_api.service.entity;

import com.birby.hrms_api.model.exception.ResourceNotFoundException;
import com.birby.hrms_api.model.entity.JobType;

public interface JobTypeEntityService {
    JobType findById(String id) throws ResourceNotFoundException;
}
