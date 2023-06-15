package com.praveen.eventsservice.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.eventsservice.dto.EventDto;
import com.praveen.eventsservice.dto.EventSuccessResponseDto;
import com.praveen.eventsservice.models.Event;
import com.praveen.eventsservice.repository.EventRepository;
import com.praveen.eventsservice.service.EventService;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventSuccessResponseDto createEvent(EventDto eventRequestDto) {
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
    public List<EventDto> getEvents() {
        return eventRepository.findAll().stream().map(p -> mapToEventDto(p)).collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getUserEvents(Integer userId) {
        List<Event> events = eventRepository.findByUserId(userId);

        return events.stream().map(p -> mapToEventDto(p)).collect(Collectors.toList());
    }

    private EventDto mapToEventDto(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setEventName(event.getEventName());
        eventDto.setEventDescription(event.getEventDescription());
        eventDto.setEventDate(event.getEventDate());
        eventDto.setEventLocation(event.getEventLocation());
        eventDto.setEventTime(event.getEventTime());
        eventDto.setUserId(event.getUserId());

        return eventDto;
    }
    
}
