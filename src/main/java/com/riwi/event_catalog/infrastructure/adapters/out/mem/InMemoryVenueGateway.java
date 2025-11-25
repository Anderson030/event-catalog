package com.riwi.event_catalog.infrastructure.adapters.out.mem;

import com.riwi.event_catalog.domain.model.Venue;
import com.riwi.event_catalog.domain.ports.out.VenueGateway;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("mem")
public class InMemoryVenueGateway implements VenueGateway {

    private final List<Venue> data = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public List<Venue> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public Optional<Venue> findById(Long id) {
        return data.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public Venue save(Venue venue) {
        if (venue.getId() == null) {
            venue.setId(sequence.incrementAndGet());
            data.add(venue);
        } else {
            deleteById(venue.getId());
            data.add(venue);
        }
        return venue;
    }

    @Override
    public void deleteById(Long id) {
        data.removeIf(v -> v.getId().equals(id));
    }
}
