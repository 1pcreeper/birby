package com.birby.hrms.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staff_salary")
public class StaffSalary {
    @Id
    private String id;
    @MapsId
    @JoinColumn(name = "staff_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Staff staff;
    @Column(name = "hourly", nullable = false)
    private BigDecimal hourly = BigDecimal.ZERO;
    @Column(name = "daily", nullable = false)
    private BigDecimal daily = BigDecimal.ZERO;
    @Column(name = "monthly", nullable = false)
    private BigDecimal monthly = BigDecimal.ZERO;
}
