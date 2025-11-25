package com.riwi.event_catalog.infrastructure.adapters.out.jpa;

import com.riwi.event_catalog.entity.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueJpaRepository extends JpaRepository<VenueEntity, Long> {
}
