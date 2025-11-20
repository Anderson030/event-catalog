package com.riwi.event_catalog.controller;

import com.riwi.event_catalog.dto.VenueDTO;
import com.riwi.event_catalog.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/venues")
@RequiredArgsConstructor
public class VenueController {

    private final VenueService service;

    @PostMapping
    public ResponseEntity<VenueDTO> create(@RequestBody VenueDTO dto) {
        VenueDTO created = service.create(dto);
        return ResponseEntity
                .created(URI.create("/venues/" + created.getId()))
                .body(created);
    }

    @GetMapping
    public ResponseEntity<List<VenueDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenueDTO> update(@PathVariable Long id,
                                           @RequestBody VenueDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
