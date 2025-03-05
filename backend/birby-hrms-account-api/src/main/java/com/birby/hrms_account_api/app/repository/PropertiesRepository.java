package com.birby.hrms_account_api.app.repository;

import com.birby.hrms_account_api.app.model.entity.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties,String> {
}
