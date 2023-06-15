package com.praveen.eventsservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventSuccessResponseDto {
    private Integer statusCode;
    private String message;
}
