package com.riwi.event_catalog.repository.jpa;

import com.riwi.event_catalog.entity.VenueEntity;
import com.riwi.event_catalog.repository.core.VenueGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("jpa")
@RequiredArgsConstructor
public class JpaVenueGateway implements VenueGateway {

    private final VenueJpaRepository repository;

    @Override
    public List<VenueEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<VenueEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public VenueEntity save(VenueEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
