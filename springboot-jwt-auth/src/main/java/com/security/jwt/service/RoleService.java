package com.security.jwt.service;

import java.util.List;

import com.security.jwt.dto.RoleDto;

public interface RoleService {
    
    List<RoleDto> getRoles();

    RoleDto createRole(RoleDto role);

}
