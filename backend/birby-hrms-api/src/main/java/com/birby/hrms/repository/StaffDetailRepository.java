package com.birby.hrms.repository;

import com.birby.hrms.model.entity.StaffDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDetailRepository extends JpaRepository<StaffDetail,String> {
}
