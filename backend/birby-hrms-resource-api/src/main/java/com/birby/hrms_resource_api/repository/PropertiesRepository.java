package com.birby.hrms_resource_api.repository;

import com.birby.hrms_resource_api.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties,String> {
}
