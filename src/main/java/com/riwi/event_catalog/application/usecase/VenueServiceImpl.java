package com.riwi.event_catalog.application.usecase;

import com.riwi.event_catalog.domain.model.Venue;
import com.riwi.event_catalog.domain.ports.in.VenueService;
import com.riwi.event_catalog.domain.ports.out.VenueGateway;
import com.riwi.event_catalog.dto.VenueDTO;
import com.riwi.event_catalog.exception.NotFoundException;
import com.riwi.event_catalog.mapper.VenueMapper;
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
        Venue venue = gateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Venue " + id + " not found"));
        return mapper.toDTO(venue);
    }

    @Override
    public VenueDTO create(VenueDTO dto) {
        Venue venue = mapper.toDomain(dto);
        venue.setId(null);
        Venue saved = gateway.save(venue);
        return mapper.toDTO(saved);
    }

    @Override
    public VenueDTO update(Long id, VenueDTO dto) {
        gateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Venue " + id + " not found"));

        Venue toUpdate = mapper.toDomain(dto);
        toUpdate.setId(id);
        Venue saved = gateway.save(toUpdate);
        return mapper.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        gateway.deleteById(id);
    }
}
