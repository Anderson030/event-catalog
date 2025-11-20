package com.riwi.event_catalog.mapper;

import com.riwi.event_catalog.dto.EventDTO;
import com.riwi.event_catalog.entity.EventEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMapper {

    public EventDTO toDTO(EventEntity entity) {
        if (entity == null) return null;

        return EventDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .date(entity.getDate())
                .venueId(entity.getVenueId())
                .build();
    }

    public EventEntity toEntity(EventDTO dto) {
        if (dto == null) return null;

        return EventEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .date(dto.getDate())
                .venueId(dto.getVenueId())
                .build();
    }

    public List<EventDTO> toDTOList(List<EventEntity> entities) {
        return entities.stream()
                .map(this::toDTO)
                .toList();
    }
}
