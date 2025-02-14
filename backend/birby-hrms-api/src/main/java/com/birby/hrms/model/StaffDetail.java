package com.birby.hrms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staff_detail")
public class StaffDetail {
    @Id
    private String id;
    @MapsId
    @JoinColumn(name = "staff_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Staff staff;
    @Column(name = "gender", nullable = false)
    private boolean gender;
    @Column(name = "birth")
    private Date birth;
    @Column(name = "hk_phone", unique = true, length = 8)
    private String hkPhone;
    @JoinColumn(name = "job_type_id",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private JobType jobType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getHkPhone() {
        return hkPhone;
    }

    public void setHkPhone(String hkPhone) {
        this.hkPhone = hkPhone;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }
}
