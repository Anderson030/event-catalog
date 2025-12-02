package com.riwi.event_catalog.infrastructure.adapters.out.jpa.spec;

import com.riwi.event_catalog.entity.EventEntity;
import org.springframework.data.jpa.domain.Specification;

public class EventSpecifications {

    private EventSpecifications() { }

    public static Specification<EventEntity> hasVenue(Long venueId) {
        return (root, query, cb) ->
                venueId == null
                        ? cb.conjunction()
                        : cb.equal(root.get("venue").get("id"), venueId);
    }

    public static Specification<EventEntity> dateBetween(String start, String end) {
        return (root, query, cb) -> {
            if (start == null && end == null) {
                return cb.conjunction();
            }
            if (start != null && end != null) {
                return cb.between(root.get("date"), start, end);
            }
            if (start != null) {
                return cb.greaterThanOrEqualTo(root.get("date"), start);
            }
            return cb.lessThanOrEqualTo(root.get("date"), end);
        };
    }
}
