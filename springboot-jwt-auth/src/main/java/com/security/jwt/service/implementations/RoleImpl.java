package com.security.jwt.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.jwt.dto.RoleDto;
import com.security.jwt.exceptions.UserRoleNotFoundException;
import com.security.jwt.models.Role;
import com.security.jwt.repository.RoleRepository;
import com.security.jwt.service.RoleService;

@Service
public class RoleImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDto> getRoles() {

        List<Role> roles = roleRepository.findAll();

        return roles.stream().map(role -> mapToDto(role)).collect(Collectors.toList());
    }

    private RoleDto mapToDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(role.getName());

        return roleDto;
    }

    @Override
    public RoleDto createRole(RoleDto roleRequest) {
        var role = Role.builder()
                .name(roleRequest.getName())
                .build();
        roleRepository.save(role);
        
        return RoleDto
                .builder()
                .name(role.getName())
                .build();
    }

    @Override
    public void updateRole(Integer id, RoleDto roleRequest) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new UserRoleNotFoundException("User role does not exist."));

        role.setName(roleRequest.getName());

        roleRepository.save(role);
    }

    @Override
    public void deleteRole(Integer id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new UserRoleNotFoundException("User role does not exist."));

        roleRepository.delete(role);
    }
    
}
