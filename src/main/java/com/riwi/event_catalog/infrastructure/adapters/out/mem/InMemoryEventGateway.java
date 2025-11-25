package com.riwi.event_catalog.infrastructure.adapters.out.mem;

import com.riwi.event_catalog.domain.model.Event;
import com.riwi.event_catalog.domain.ports.out.EventGateway;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("mem")
public class InMemoryEventGateway implements EventGateway {

    private final List<Event> data = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return data.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public Event save(Event event) {
        if (event.getId() == null) {
            event.setId(sequence.incrementAndGet());
            data.add(event);
        } else {
            data.removeIf(e -> e.getId().equals(event.getId()));
            data.add(event);
        }
        return event;
    }

    @Override
    public void deleteById(Long id) {
        data.removeIf(e -> e.getId().equals(id));
    }
}
