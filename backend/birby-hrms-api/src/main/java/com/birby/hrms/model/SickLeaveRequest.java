package com.birby.hrms.model;

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
@Table(name = "sickleave_request")
public class SickLeaveRequest {
    @Id
    private int id;
    @MapsId
    @JoinColumn(name = "req_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private String reqId;
    @JoinColumn(name = "sick_leave_id", nullable = false)
    private SickLeave sickLeave;

}
