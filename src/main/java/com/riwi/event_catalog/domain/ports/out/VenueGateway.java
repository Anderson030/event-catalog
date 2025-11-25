package com.riwi.event_catalog.domain.ports.out;

import com.riwi.event_catalog.domain.model.Venue;

import java.util.List;
import java.util.Optional;

public interface VenueGateway {

    List<Venue> findAll();

    Optional<Venue> findById(Long id);

    Venue save(Venue venue);

    void deleteById(Long id);
}
