package com.praveen.eventsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praveen.eventsservice.models.Event;
import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByUserId(Integer userId);
}
