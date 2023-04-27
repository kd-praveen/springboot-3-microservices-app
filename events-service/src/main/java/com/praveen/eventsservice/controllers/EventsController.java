package com.praveen.eventsservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {
    
    @GetMapping("")
    public String getEvents(){
        return "List of events";
    }
}
