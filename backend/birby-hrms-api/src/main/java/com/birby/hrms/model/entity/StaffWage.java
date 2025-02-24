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
@Table(name = "staff_wage")
public class StaffWage {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @JoinColumn(name = "attend_id", nullable = false, unique = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private Attendance attendance;
    @Column(name = "wage", nullable = false)
    private BigDecimal wage;
    @Column(name = "is_paid")
    private boolean isPaid = false;
}
