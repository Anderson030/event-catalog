package com.riwi.event_catalog.service;

import com.riwi.event_catalog.dto.EventDTO;

import java.util.List;

public interface EventService {

    List<EventDTO> getAll();

    EventDTO getById(Long id);

    EventDTO create(EventDTO dto);

    EventDTO update(Long id, EventDTO dto);

    void delete(Long id);
}
