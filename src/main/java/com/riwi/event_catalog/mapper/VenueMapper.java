package com.riwi.event_catalog.mapper;

import com.riwi.event_catalog.dto.VenueDTO;
import com.riwi.event_catalog.entity.VenueEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VenueMapper {

    public VenueDTO toDTO(VenueEntity entity) {
        if (entity == null) return null;

        return VenueDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .capacity(entity.getCapacity())
                .build();
    }

    public VenueEntity toEntity(VenueDTO dto) {
        if (dto == null) return null;

        return VenueEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .capacity(dto.getCapacity())
                .build();
    }

    public List<VenueDTO> toDTOList(List<VenueEntity> entities) {
        return entities.stream()
                .map(this::toDTO)
                .toList();
    }
}
