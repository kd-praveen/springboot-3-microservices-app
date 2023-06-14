package com.praveen.eventsservice.dto;

import java.sql.Date;
import java.time.LocalTime;

import lombok.Data;

@Data
public class EventRequestDto {
    
    private String eventName;

    private Date eventDate;

    private LocalTime eventTime;

    private String eventLocation;

    private String eventDescription;

    private Integer userId;
}
