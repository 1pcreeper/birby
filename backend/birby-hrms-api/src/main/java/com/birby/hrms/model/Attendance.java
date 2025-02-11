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
@Table(
        name = "attendance",
        uniqueConstraints = @UniqueConstraint(columnNames = {"staff_id", "date"})
)
public class Attendance {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;
    @Column(name = "date", nullable = false)
    private Date date;
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift shift;
    @JoinColumn(name = "sick_leave_id")
    private SickLeave sickLeave;
    @JoinColumn(name = "venue_id")
    private Venue venue;
    @Column(name = "task")
    private String task;
}
