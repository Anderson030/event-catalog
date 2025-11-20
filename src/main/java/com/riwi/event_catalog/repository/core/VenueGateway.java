package com.riwi.event_catalog.repository.core;

import com.riwi.event_catalog.entity.VenueEntity;

import java.util.List;
import java.util.Optional;

public interface VenueGateway {

    List<VenueEntity> findAll();

    Optional<VenueEntity> findById(Long id);

    VenueEntity save(VenueEntity entity);

    void deleteById(Long id);
}
