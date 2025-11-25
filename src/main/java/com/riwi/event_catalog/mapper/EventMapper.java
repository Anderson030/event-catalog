package com.riwi.event_catalog.mapper;

import com.riwi.event_catalog.domain.model.Event;
import com.riwi.event_catalog.dto.EventDTO;
import com.riwi.event_catalog.entity.EventEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {

    // ===== Domain -> DTO =====
    public EventDTO toDTO(Event event) {
        if (event == null) return null;

        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());

        // LocalDate (domain) -> String (DTO)
        dto.setDate(
                event.getDate() != null
                        ? event.getDate().toString()
                        : null
        );

        dto.setVenueId(event.getVenueId());
        return dto;
    }

    public List<EventDTO> toDTOList(List<Event> events) {
        return events.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // ===== DTO -> Domain =====
    public Event toDomain(EventDTO dto) {
        if (dto == null) return null;

        Event event = new Event();
        event.setId(dto.getId());
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());

        // String (DTO) -> LocalDate (domain)
        if (dto.getDate() != null && !dto.getDate().isBlank()) {
            event.setDate(LocalDate.parse(dto.getDate()));
        } else {
            event.setDate(null);
        }

        event.setVenueId(dto.getVenueId());
        return event;
    }

    // ===== Domain -> Entity =====
    public EventEntity toEntity(Event event) {
        if (event == null) return null;

        EventEntity entity = new EventEntity();
        entity.setId(event.getId());
        entity.setName(event.getName());
        entity.setDescription(event.getDescription());

        // LocalDate (domain) -> String (entity)
        entity.setDate(
                event.getDate() != null
                        ? event.getDate().toString()
                        : null
        );

        entity.setVenueId(event.getVenueId());
        return entity;
    }

    // ===== Entity -> Domain =====
    public Event toDomain(EventEntity entity) {
        if (entity == null) return null;

        Event event = new Event();
        event.setId(entity.getId());
        event.setName(entity.getName());
        event.setDescription(entity.getDescription());

        // String (entity) -> LocalDate (domain)
        if (entity.getDate() != null && !entity.getDate().isBlank()) {
            event.setDate(LocalDate.parse(entity.getDate()));
        } else {
            event.setDate(null);
        }

        event.setVenueId(entity.getVenueId());
        return event;
    }
}
