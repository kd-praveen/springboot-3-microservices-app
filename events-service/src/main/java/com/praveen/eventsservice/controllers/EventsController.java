package com.praveen.eventsservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.eventsservice.dto.EventDto;
import com.praveen.eventsservice.dto.EventSuccessResponseDto;
import com.praveen.eventsservice.service.EventService;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

    @Autowired
    private EventService eventService;
    
    @GetMapping("")
    public List<EventDto> getEventsList(){
        return eventService.getEvents();
    }

    @PostMapping("create")
    public ResponseEntity<EventSuccessResponseDto> createEvent( @RequestBody EventDto eventRequestDto){
        var createEvent = eventService.createEvent(eventRequestDto);

        return new ResponseEntity<>(createEvent, HttpStatus.OK);

    }

    @GetMapping("users/{id}")
    public List<EventDto> getUserEvents(@PathVariable Integer id){

        return eventService.getUserEvents(id);

    }
}
