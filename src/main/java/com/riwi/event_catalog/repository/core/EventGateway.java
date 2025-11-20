package com.riwi.event_catalog.repository.core;

import com.riwi.event_catalog.entity.EventEntity;

import java.util.List;
import java.util.Optional;

public interface EventGateway {

    List<EventEntity> findAll();

    Optional<EventEntity> findById(Long id);

    EventEntity save(EventEntity entity);

    void deleteById(Long id);
}
