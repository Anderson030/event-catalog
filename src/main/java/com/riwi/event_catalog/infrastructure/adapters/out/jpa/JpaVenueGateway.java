package com.riwi.event_catalog.infrastructure.adapters.out.jpa;

import com.riwi.event_catalog.domain.model.Venue;
import com.riwi.event_catalog.domain.ports.out.VenueGateway;
import com.riwi.event_catalog.entity.VenueEntity;
import com.riwi.event_catalog.mapper.VenueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Profile("jpa")
@RequiredArgsConstructor
public class JpaVenueGateway implements VenueGateway {

    private final VenueJpaRepository repository;
    private final VenueMapper mapper;

    @Override
    public List<Venue> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Venue> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Venue save(Venue venue) {
        VenueEntity entity = mapper.toEntity(venue);
        VenueEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
