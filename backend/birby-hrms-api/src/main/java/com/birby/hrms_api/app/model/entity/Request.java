package com.birby.hrms_api.app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "request")
public class Request {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @JoinColumn(name = "req_method_id",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private RequestMethod requestMethod;
    @JoinColumn(name = "from_staff_id",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Staff staff;
    @Column(name = "time",nullable = false)
    private LocalDateTime time;
    @Column(name = "is_approved",nullable = true)
    private boolean isApproved;

}
