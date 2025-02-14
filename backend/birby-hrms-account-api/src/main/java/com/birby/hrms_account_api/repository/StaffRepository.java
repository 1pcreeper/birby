package com.birby.hrms_account_api.repository;

import com.birby.hrms_account_api.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
    @Query(value = "SELECT s FROM Staff s WHERE LOWER(s.name) = LOWER(:name)")
    Optional<Staff> findByName(@Param("name") String name);

    @Query(value = "SELECT s FROM Staff s WHERE s.uid = :uid")
    Optional<Staff> findByUid(@Param("uid") String uid);

    @Query(value = "SELECT s FROM Staff s WHERE LOWER(s.email) = LOWER(:email)")
    Optional<Staff> findByEmail(@Param("email") String email);
}
