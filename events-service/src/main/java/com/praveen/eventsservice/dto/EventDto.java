package com.praveen.eventsservice.dto;

import java.time.LocalTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    
    private String eventName;

    private Date eventDate;

    private LocalTime eventTime;

    private String eventLocation;

    private String eventDescription;

    private Integer userId;
}
