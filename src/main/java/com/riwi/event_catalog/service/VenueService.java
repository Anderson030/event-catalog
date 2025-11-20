package com.riwi.event_catalog.service;

import com.riwi.event_catalog.dto.VenueDTO;

import java.util.List;

public interface VenueService {

    List<VenueDTO> getAll();

    VenueDTO getById(Long id);

    VenueDTO create(VenueDTO dto);

    VenueDTO update(Long id, VenueDTO dto);

    void delete(Long id);
}
