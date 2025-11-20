package com.riwi.event_catalog.service;

import com.riwi.event_catalog.dto.EventDTO;
import com.riwi.event_catalog.entity.EventEntity;
import com.riwi.event_catalog.exception.BadRequestException;
import com.riwi.event_catalog.exception.NotFoundException;
import com.riwi.event_catalog.mapper.EventMapper;
import com.riwi.event_catalog.repository.core.EventGateway;
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
        EventEntity entity = gateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Event " + id + " not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public EventDTO create(EventDTO dto) {
        validate(dto);
        EventEntity entity = mapper.toEntity(dto);
        entity.setId(null); // que el id lo genere el gateway
        EventEntity saved = gateway.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    public EventDTO update(Long id, EventDTO dto) {
        validate(dto);

        EventEntity existing = gateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Event " + id + " not found"));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setDate(dto.getDate());
        existing.setVenueId(dto.getVenueId());

        EventEntity saved = gateway.save(existing);
        return mapper.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        gateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Event " + id + " not found"));
        gateway.deleteById(id);
    }

    private void validate(EventDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new BadRequestException("Event name cannot be empty");
        }
    }
}
