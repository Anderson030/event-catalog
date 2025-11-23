package com.riwi.event_catalog.repository.jpa;

import com.riwi.event_catalog.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepository extends JpaRepository<EventEntity, Long> {
}
