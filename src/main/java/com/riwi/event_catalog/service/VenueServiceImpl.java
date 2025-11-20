package com.riwi.event_catalog.service;

import com.riwi.event_catalog.dto.VenueDTO;
import com.riwi.event_catalog.entity.VenueEntity;
import com.riwi.event_catalog.exception.BadRequestException;
import com.riwi.event_catalog.exception.NotFoundException;
import com.riwi.event_catalog.mapper.VenueMapper;
import com.riwi.event_catalog.repository.core.VenueGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueServiceImpl implements VenueService {

    private final VenueGateway gateway;
    private final VenueMapper mapper;

    @Override
    public List<VenueDTO> getAll() {
        return mapper.toDTOList(gateway.findAll());
    }

    @Override
    public VenueDTO getById(Long id) {
        VenueEntity entity = gateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Venue " + id + " not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public VenueDTO create(VenueDTO dto) {
        validate(dto);
        VenueEntity entity = mapper.toEntity(dto);
        entity.setId(null);
        VenueEntity saved = gateway.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    public VenueDTO update(Long id, VenueDTO dto) {
        validate(dto);

        VenueEntity existing = gateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Venue " + id + " not found"));

        existing.setName(dto.getName());
        existing.setAddress(dto.getAddress());
        existing.setCapacity(dto.getCapacity());

        VenueEntity saved = gateway.save(existing);
        return mapper.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        gateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Venue " + id + " not found"));
        gateway.deleteById(id);
    }

    private void validate(VenueDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new BadRequestException("Venue name cannot be empty");
        }
    }
}
