package com.birby.hrms_resource_api.repository;

import com.birby.hrms_resource_api.model.StaffRole;
import com.birby.hrms_resource_api.model.id.StaffRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRoleRepository extends JpaRepository<StaffRole, StaffRoleId> {
}
