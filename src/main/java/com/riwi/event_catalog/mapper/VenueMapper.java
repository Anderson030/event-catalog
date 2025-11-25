package com.riwi.event_catalog.mapper;

import com.riwi.event_catalog.domain.model.Venue;
import com.riwi.event_catalog.dto.VenueDTO;
import com.riwi.event_catalog.entity.VenueEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VenueMapper {

    // ===== Domain -> DTO =====
    public VenueDTO toDTO(Venue venue) {
        if (venue == null) return null;

        VenueDTO dto = new VenueDTO();
        dto.setId(venue.getId());
        dto.setName(venue.getName());
        dto.setCity(venue.getCity());
        dto.setCapacity(venue.getCapacity());
        return dto;
    }

    public List<VenueDTO> toDTOList(List<Venue> venues) {
        return venues.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // ===== DTO -> Domain =====
    public Venue toDomain(VenueDTO dto) {
        if (dto == null) return null;

        Venue venue = new Venue();
        venue.setId(dto.getId());
        venue.setName(dto.getName());
        venue.setCity(dto.getCity());
        venue.setCapacity(dto.getCapacity());
        return venue;
    }

    // ===== Entity -> Domain =====
    public Venue toDomain(VenueEntity entity) {
        if (entity == null) return null;

        Venue venue = new Venue();
        venue.setId(entity.getId());
        venue.setName(entity.getName());
        venue.setCity(entity.getCity());
        venue.setCapacity(entity.getCapacity());
        return venue;
    }

    // ===== Domain -> Entity =====
    public VenueEntity toEntity(Venue venue) {
        if (venue == null) return null;

        VenueEntity entity = new VenueEntity();
        entity.setId(venue.getId());
        entity.setName(venue.getName());
        entity.setCity(venue.getCity());
        entity.setCapacity(venue.getCapacity());
        return entity;
    }
}
