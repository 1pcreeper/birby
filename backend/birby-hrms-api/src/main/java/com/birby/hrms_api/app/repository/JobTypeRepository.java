package com.birby.hrms_api.repository;

import com.birby.hrms_api.model.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType,String> {
}
