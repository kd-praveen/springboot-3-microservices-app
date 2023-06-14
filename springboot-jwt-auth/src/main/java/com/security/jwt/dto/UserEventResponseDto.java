package com.security.jwt.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEventResponseDto {
    
    private Integer id;   

    private String firstname;

    private String lastname;

    private String email;

    private List<EventDto> events;

}
