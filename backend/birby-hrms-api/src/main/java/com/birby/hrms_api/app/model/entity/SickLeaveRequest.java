package com.birby.hrms_api.app.model.entity;

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
    private String id;
    @MapsId
    @JoinColumn(name = "req_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Request request;
    @JoinColumn(name = "sick_leave_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private SickLeave sickLeave;

}
