package com.riwi.event_catalog.repository.mem;

import com.riwi.event_catalog.entity.EventEntity;
import com.riwi.event_catalog.repository.core.EventGateway;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("mem")
public class InMemoryEventGateway implements EventGateway {

    private final List<EventEntity> data = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public List<EventEntity> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public Optional<EventEntity> findById(Long id) {
        return data.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public EventEntity save(EventEntity entity) {
        if (entity.getId() == null) {
            // crear
            entity.setId(sequence.incrementAndGet());
            data.add(entity);
        } else {
            // actualizar
            deleteById(entity.getId());
            data.add(entity);
        }
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        data.removeIf(e -> e.getId().equals(id));
    }
}
