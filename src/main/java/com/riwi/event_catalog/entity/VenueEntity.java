package com.riwi.event_catalog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VenueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Integer capacity;


    @OneToMany(
            mappedBy = "venue",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<EventEntity> events = new ArrayList<>();

    // ===== Helpers de ciclo de vida =====

    public void addEvent(EventEntity event) {
        events.add(event);
        event.setVenue(this);
    }

    public void removeEvent(EventEntity event) {
        events.remove(event);
        event.setVenue(null);
    }
}
