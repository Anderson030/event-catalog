package com.riwi.event_catalog.infrastructure.adapters.out.jpa;

import com.riwi.event_catalog.domain.model.Event;
import com.riwi.event_catalog.domain.ports.out.EventGateway;
import com.riwi.event_catalog.entity.EventEntity;
import com.riwi.event_catalog.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Profile("jpa")
@RequiredArgsConstructor
public class JpaEventGateway implements EventGateway {

    private final EventJpaRepository repository;
    private final EventMapper mapper;

    @Override
    public List<Event> findAll() {
        return repository.findAll()
                .stream()
                .map(entity -> mapper.toDomain(entity))   // Entity -> Domain
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Event> findById(Long id) {
        return repository.findById(id)
                .map(entity -> mapper.toDomain(entity));   // Entity -> Domain
    }

    @Override
    public Event save(Event event) {
        // Domain -> Entity
        EventEntity entity = mapper.toEntity(event);
        EventEntity saved = repository.save(entity);

        // Entity -> Domain
        return mapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
