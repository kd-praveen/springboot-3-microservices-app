package com.security.jwt.controllers.user_events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.dto.UserEventResponseDto;
import com.security.jwt.service.UserEventsService;

@RestController
@RequestMapping("/api/v1/user-events")
public class UserEventController {

    @Autowired
    private UserEventsService userEventsService;
    
    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserEventResponseDto> userEvents(@PathVariable("id") Integer userId){
        var userEvents = userEventsService.getUserEvents(userId);

        return new ResponseEntity<>(userEvents, HttpStatus.OK);
    }
}
