package com.riwi.event_catalog.mapper;

import com.riwi.event_catalog.domain.model.Event;
import com.riwi.event_catalog.dto.EventDTO;
import com.riwi.event_catalog.entity.EventEntity;
import com.riwi.event_catalog.entity.VenueEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {


    public EventDTO toDTO(Event event) {
        if (event == null) return null;

        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());

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


    public Event toDomain(EventDTO dto) {
        if (dto == null) return null;

        Event event = new Event();
        event.setId(dto.getId());
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());


        if (dto.getDate() != null && !dto.getDate().isBlank()) {
            event.setDate(LocalDate.parse(dto.getDate()));
        } else {
            event.setDate(null);
        }

        event.setVenueId(dto.getVenueId());
        return event;
    }


    public EventEntity toEntity(Event event) {
        if (event == null) return null;

        EventEntity entity = new EventEntity();
        entity.setId(event.getId());
        entity.setName(event.getName());
        entity.setDescription(event.getDescription());

        entity.setDate(
                event.getDate() != null
                        ? event.getDate().toString()
                        : null
        );


        if (event.getVenueId() != null) {
            VenueEntity venueRef = new VenueEntity();
            venueRef.setId(event.getVenueId());
            entity.setVenue(venueRef);
        }

        return entity;
    }


    public Event toDomain(EventEntity entity) {
        if (entity == null) return null;

        Event event = new Event();
        event.setId(entity.getId());
        event.setName(entity.getName());
        event.setDescription(entity.getDescription());


        if (entity.getDate() != null && !entity.getDate().isBlank()) {
            event.setDate(LocalDate.parse(entity.getDate()));
        } else {
            event.setDate(null);
        }


        if (entity.getVenue() != null) {
            event.setVenueId(entity.getVenue().getId());
        } else {
            event.setVenueId(null);
        }

        return event;
    }
}
