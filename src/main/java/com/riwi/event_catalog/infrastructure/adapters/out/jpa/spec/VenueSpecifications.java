package com.riwi.event_catalog.infrastructure.adapters.out.jpa.spec;

import com.riwi.event_catalog.entity.VenueEntity;
import org.springframework.data.jpa.domain.Specification;

public class VenueSpecifications {

    private VenueSpecifications() { }

    public static Specification<VenueEntity> cityContains(String city) {
        return (root, query, cb) ->
                city == null || city.isBlank()
                        ? cb.conjunction()
                        : cb.like(cb.lower(root.get("city")), "%" + city.toLowerCase() + "%");
    }

    public static Specification<VenueEntity> capacityGreaterOrEqual(Integer capacity) {
        return (root, query, cb) ->
                capacity == null
                        ? cb.conjunction()
                        : cb.greaterThanOrEqualTo(root.get("capacity"), capacity);
    }
}
