package com.riwi.event_catalog.domain.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private Long venueId;
}
