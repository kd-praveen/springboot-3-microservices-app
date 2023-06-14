package com.praveen.eventsservice.service;

import java.util.List;

import com.praveen.eventsservice.dto.EventDto;
import com.praveen.eventsservice.dto.EventSuccessResponseDto;

public interface EventService {
    
    EventSuccessResponseDto createEvent(EventDto eventRequestDto);

    List<EventDto> getEvents();

    List<EventDto> getUserEvents(Integer userId);
}
