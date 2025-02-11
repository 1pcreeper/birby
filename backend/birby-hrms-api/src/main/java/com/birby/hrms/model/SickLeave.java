package com.birby.hrms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;

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
    @JoinColumn(name = "leave_approval_id",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private LeaveApproval leaveApproval;
    @JoinColumn(name = "leave_wage_type_id",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private LeaveWageType leaveWageType;
}
