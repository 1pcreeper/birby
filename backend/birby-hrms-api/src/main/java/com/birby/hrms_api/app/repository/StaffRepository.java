package com.birby.hrms_api.app.repository;

import com.birby.hrms_api.app.model.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff,String> {
    @Query(value = "SELECT s FROM Staff s WHERE s.uid = :uid")
    Optional<Staff> findByUid(@Param(value = "uid")String uid);
}
