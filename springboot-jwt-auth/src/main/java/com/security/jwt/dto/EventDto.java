package com.security.jwt.dto;

import java.sql.Date;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
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
