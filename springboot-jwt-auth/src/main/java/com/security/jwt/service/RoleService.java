package com.security.jwt.service;

import java.util.List;

import com.security.jwt.dto.RoleDto;

public interface RoleService {
    
    List<RoleDto> getRoles();

    RoleDto createRole(RoleDto role);

    void updateRole(Integer id, RoleDto role);

    void deleteRole(Integer id);

}
