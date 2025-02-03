package com.birby.hrms_resource_api.repository;

import com.birby.hrms_resource_api.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
    @Query(value = "SELECT s FROM Staff s WHERE LOWER(s.name) = LOWER(:name) LIMIT 1")
    Optional<Staff> findByName(@Param("name") String name);

    @Query(value = "SELECT s FROM Staff s WHERE s.uid = :uid LIMIT 1")
    Optional<Staff> findByUid(@Param("uid") String uid);

    @Query(value = "SELECT s FROM Staff s WHERE LOWER(s.email) = LOWER(:email) LIMIT 1")
    Optional<Staff> findByEmail(@Param("email") String email);
}
