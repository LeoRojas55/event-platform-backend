package com.davivienda.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.events.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}