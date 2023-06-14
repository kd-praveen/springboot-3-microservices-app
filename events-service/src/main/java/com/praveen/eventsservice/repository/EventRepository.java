package com.praveen.eventsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praveen.eventsservice.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByUserId(Integer userId);
}
