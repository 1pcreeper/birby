package com.birby.hrms_api.app.repository;

import com.birby.hrms_api.app.model.entity.StaffDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDetailRepository extends JpaRepository<StaffDetail,String> {
}
