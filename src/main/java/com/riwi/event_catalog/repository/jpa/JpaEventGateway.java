package com.riwi.event_catalog.repository.jpa;

import com.riwi.event_catalog.entity.EventEntity;
import com.riwi.event_catalog.repository.core.EventGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("jpa")
@RequiredArgsConstructor
public class JpaEventGateway implements EventGateway {

    private final EventJpaRepository repository;

    @Override
    public List<EventEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<EventEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public EventEntity save(EventEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
