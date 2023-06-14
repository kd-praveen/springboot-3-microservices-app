package com.praveen.eventsservice.service;

import java.util.List;

import com.praveen.eventsservice.dto.EventRequestDto;
import com.praveen.eventsservice.dto.EventSuccessResponseDto;
import com.praveen.eventsservice.models.Event;

public interface EventService {
    
    EventSuccessResponseDto createEvent(EventRequestDto eventRequestDto);

    List<Event> getEvents();
}
