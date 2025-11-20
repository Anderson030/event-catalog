package com.riwi.event_catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private String date;
    private Long venueId;
}
