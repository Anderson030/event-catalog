package com.riwi.event_catalog.repository.mem;

import com.riwi.event_catalog.entity.VenueEntity;
import com.riwi.event_catalog.repository.core.VenueGateway;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("mem")
public class InMemoryVenueGateway implements VenueGateway {

    private final List<VenueEntity> data = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public List<VenueEntity> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public Optional<VenueEntity> findById(Long id) {
        return data.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public VenueEntity save(VenueEntity entity) {
        if (entity.getId() == null) {
            entity.setId(sequence.incrementAndGet());
            data.add(entity);
        } else {
            deleteById(entity.getId());
            data.add(entity);
        }
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        data.removeIf(v -> v.getId().equals(id));
    }
}
