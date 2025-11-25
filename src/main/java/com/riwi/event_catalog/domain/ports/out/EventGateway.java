package com.riwi.event_catalog.domain.ports.out;

import com.riwi.event_catalog.domain.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {

    List<Event> findAll();

    Optional<Event> findById(Long id);

    Event save(Event event);

    void deleteById(Long id);
}
