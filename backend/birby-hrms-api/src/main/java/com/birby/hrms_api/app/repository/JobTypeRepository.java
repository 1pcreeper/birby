package com.birby.hrms_api.app.repository;

import com.birby.hrms_api.app.model.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType,String> {
}
