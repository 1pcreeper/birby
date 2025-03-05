package com.birby.hrms_api.model.entity.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StaffVenuePreferenceId implements Serializable {
    private String staffId;
    private String venueId;
}
