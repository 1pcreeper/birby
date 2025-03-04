package com.birby.hrms_api.model.entity;

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
public class Duty {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;
    @Column(name = "date", nullable = false)
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift shift;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sick_leave_id")
    private SickLeave sickLeave;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venue_id")
    private Venue venue;
    @Column(name = "task")
    private String task;
}
