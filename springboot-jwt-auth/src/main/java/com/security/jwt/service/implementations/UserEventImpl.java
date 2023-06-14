package com.security.jwt.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.security.jwt.dto.EventDto;
import com.security.jwt.dto.UserEventResponseDto;
import com.security.jwt.models.User;
import com.security.jwt.repository.UserRepository;
import com.security.jwt.service.UserEventsService;

import reactor.core.publisher.Flux;

@Service
public class UserEventImpl implements UserEventsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEventResponseDto getUserEvents(Integer user_id) {
        
        User user =  userRepository.findById(user_id).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        WebClient webClient = WebClient.create("http://localhost:8081/api/v1");

        // Get all events from the events service.
        Flux<EventDto> events = webClient.get()
                .uri("/events/users/{id}",user_id)
                .retrieve()
                .bodyToFlux(EventDto.class);

        // Convert the Flux to a List.
        List<EventDto> eventsList = events.collectList().block();

        return UserEventResponseDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .events(eventsList)
                .build();

    }
    
}
