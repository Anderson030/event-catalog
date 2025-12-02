package com.riwi.event_catalog.infrastructure.adapters.out.jpa;

import com.riwi.event_catalog.entity.EventEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventJpaRepository extends
        JpaRepository<EventEntity, Long>,
        JpaSpecificationExecutor<EventEntity> {


    List<EventEntity> findByVenue_Id(Long venueId);


    List<EventEntity> findByDate(String date);


    @Query("""
           SELECT e
           FROM EventEntity e
           JOIN FETCH e.venue v
           WHERE v.id = :venueId
           """)
    List<EventEntity> findAllByVenueIdWithVenue(@Param("venueId") Long venueId);


    @EntityGraph(attributePaths = "venue")
    @Query("SELECT e FROM EventEntity e")
    List<EventEntity> findAllWithVenue();
}
