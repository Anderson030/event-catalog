package com.riwi.event_catalog.application.usecase;

import com.riwi.event_catalog.domain.model.Event;
import com.riwi.event_catalog.domain.ports.in.EventService;
import com.riwi.event_catalog.domain.ports.out.EventGateway;
import com.riwi.event_catalog.dto.EventDTO;
import com.riwi.event_catalog.exception.NotFoundException;
import com.riwi.event_catalog.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventGateway gateway;
    private final EventMapper mapper;

    @Override
    public List<EventDTO> getAll() {
        return mapper.toDTOList(gateway.findAll());
    }

    @Override
    public EventDTO getById(Long id) {
        Event event = gateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Event " + id + " not found"));
        return mapper.toDTO(event);
    }

    @Override
    public EventDTO create(EventDTO dto) {
        Event event = mapper.toDomain(dto);
        event.setId(null); // lo genera la DB
        Event saved = gateway.save(event);
        return mapper.toDTO(saved);
    }

    @Override
    public EventDTO update(Long id, EventDTO dto) {
        gateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Event " + id + " not found"));

        Event toUpdate = mapper.toDomain(dto);
        toUpdate.setId(id);
        Event saved = gateway.save(toUpdate);
        return mapper.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        gateway.deleteById(id);
    }
}
