package com.birby.hrms_api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sick_leave")
public class SickLeave {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @JoinColumn(name = "leave_wage_type_id",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private LeaveWageType leaveWageType;
}
