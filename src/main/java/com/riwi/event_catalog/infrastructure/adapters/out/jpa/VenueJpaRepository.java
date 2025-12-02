package com.riwi.event_catalog.infrastructure.adapters.out.jpa;

import com.riwi.event_catalog.entity.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueJpaRepository extends
        JpaRepository<VenueEntity, Long>,
        JpaSpecificationExecutor<VenueEntity> {


    List<VenueEntity> findByCityContainingIgnoreCase(String city);


    List<VenueEntity> findByCapacityGreaterThanEqual(Integer capacity);
}
