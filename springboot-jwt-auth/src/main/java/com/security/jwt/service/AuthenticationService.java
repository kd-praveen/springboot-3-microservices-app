package com.security.jwt.service;

import com.security.jwt.dto.AuthenticationRequestDto;
import com.security.jwt.dto.AuthenticationResponseDto;
import com.security.jwt.dto.UserRegisterRequestDto;
import com.security.jwt.dto.UserRegisterResponseDto;

import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    UserRegisterResponseDto register(UserRegisterRequestDto request);
    
    AuthenticationResponseDto authenticate(AuthenticationRequestDto request);

    AuthenticationResponseDto refreshToken(HttpServletRequest request);
}
