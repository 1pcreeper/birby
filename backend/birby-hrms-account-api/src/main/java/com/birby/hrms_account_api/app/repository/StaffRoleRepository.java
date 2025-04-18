package com.birby.hrms_account_api.app.repository;

import com.birby.hrms_account_api.app.model.entity.StaffRole;
import com.birby.hrms_account_api.app.model.entity.id.StaffRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRoleRepository extends JpaRepository<StaffRole, StaffRoleId> {
    @Query(value = "SELECT sr FROM StaffRole sr WHERE sr.id.staffId = :staffId")
    Optional<List<StaffRole>> findByStaffId(@Param("staffId") String staffId);

    @Modifying
    @Query(value = "INSERT INTO staff_role (staff_id,role_id) VALUES (:staffId,:roleId)", nativeQuery = true)
    int add(@Param("staffId") String staffId, @Param("roleId") String roleId);
}
