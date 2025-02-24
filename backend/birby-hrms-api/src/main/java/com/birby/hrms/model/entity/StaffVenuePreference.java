package com.birby.hrms.model.entity;

import com.birby.hrms.model.entity.id.StaffVenuePreferenceId;
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
@Table(name = "staff_venue_preference")
public class StaffVenuePreference {
    @EmbeddedId
    private StaffVenuePreferenceId id;
    @JoinColumn(name="staff_id")
    @MapsId("staffId")
    @ManyToOne(cascade = CascadeType.ALL)
    private Staff staff;
    @JoinColumn(name="venue_id")
    @MapsId("venueId")
    @ManyToOne(cascade = CascadeType.ALL)
    private Venue venue;
    @Column(name = "z_index")
    private int zIndex = 0;
}
