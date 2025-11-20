package com.riwi.event_catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VenueEntity {

    private Long id;
    private String name;
    private String address;
    private Integer capacity;
}
