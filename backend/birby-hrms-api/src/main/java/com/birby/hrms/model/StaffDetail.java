package com.birby.hrms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staff_detail")
public class StaffDetail {
    @Id
    @Column(name = "staff_id", nullable = false)
    private String staffId;
    @Column(name = "gender", nullable = false)
    private boolean gender;
    @Column(name = "birth")
    private Date birth;
    @Column(name = "hk_phone", unique = true, length = 8)
    private String hkPhone;
    @JoinColumn(name = "job_type_id",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private JobType jobType;


}
