package com.birby.hrms.service.entity;

import com.birby.hrms.exception.ResourceNotFoundException;
import com.birby.hrms.model.entity.JobType;

public interface JobTypeEntityService {
    JobType findById(String id) throws ResourceNotFoundException;
}
