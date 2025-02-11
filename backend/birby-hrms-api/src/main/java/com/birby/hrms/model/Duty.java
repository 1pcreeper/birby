package com.birby.hrms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "duty")
public class Duty {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @JoinColumn(name = "attend_id", nullable = false, unique = true)
    private Attendance attendance;
    @Column(name = "arrive_time")
    private Time arriveTime;
    @Column(name = "leave_time")
    private Time leaveTime;
    @Column(name = "report")
    private String report;
}
