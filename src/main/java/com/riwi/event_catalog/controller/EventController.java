package com.riwi.event_catalog.controller;

import com.riwi.event_catalog.dto.EventDTO;
import com.riwi.event_catalog.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService service;

    @PostMapping
    public ResponseEntity<EventDTO> create(@RequestBody EventDTO dto) {
        EventDTO created = service.create(dto);
        return ResponseEntity
                .created(URI.create("/events/" + created.getId()))
                .body(created);
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id,
                                           @RequestBody EventDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
