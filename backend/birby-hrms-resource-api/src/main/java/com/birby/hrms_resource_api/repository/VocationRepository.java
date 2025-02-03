package com.birby.hrms_resource_api.repository;

import com.birby.hrms_resource_api.model.Vocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocationRepository extends JpaRepository<Vocation,String> {
}
