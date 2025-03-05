package com.birby.hrms_api.app.service.entity;

import com.birby.hrms_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_api.app.model.entity.JobType;

public interface JobTypeEntityService {
    JobType findById(String id) throws ResourceNotFoundException;
}
