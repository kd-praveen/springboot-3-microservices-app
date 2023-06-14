package com.praveen.eventsservice.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.eventsservice.dto.EventRequestDto;
import com.praveen.eventsservice.dto.EventSuccessResponseDto;
import com.praveen.eventsservice.models.Event;
import com.praveen.eventsservice.repository.EventRepository;
import com.praveen.eventsservice.service.EventService;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventSuccessResponseDto createEvent(EventRequestDto eventRequestDto) {
        var event = Event.builder()
                .eventName(eventRequestDto.getEventName())
                .eventDescription(eventRequestDto.getEventDescription())
                .eventDate(eventRequestDto.getEventDate())
                .eventLocation(eventRequestDto.getEventLocation())
                .eventTime(eventRequestDto.getEventTime())
                .userId(eventRequestDto.getUserId())
                .build();
        eventRepository.save(event);
        
        return EventSuccessResponseDto
                .builder()
                .statusCode(201)
                .message("Event created successfully")
                .build();
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }
    
}
