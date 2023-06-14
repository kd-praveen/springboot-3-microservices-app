package com.security.jwt.service;

import com.security.jwt.dto.UserEventResponseDto;

public interface UserEventsService {
    UserEventResponseDto getUserEvents(Integer id);
}
