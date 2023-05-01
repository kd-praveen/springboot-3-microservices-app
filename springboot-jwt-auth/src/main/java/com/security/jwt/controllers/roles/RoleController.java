package com.security.jwt.controllers.roles;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.dto.JsonResponseDto;
import com.security.jwt.dto.RoleDto;
import com.security.jwt.service.RoleService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/roles/")
public class RoleController {

    @Autowired
    private RoleService roleService;
    
    @GetMapping("list")
    public List<RoleDto> getRoles(){
        return roleService.getRoles();
    }

    @PostMapping("create")
    @ResponseBody
    public ResponseEntity<JsonResponseDto> createRole(@RequestBody RoleDto roleDto){

        roleService.createRole(roleDto);

        JsonResponseDto successResponse = new JsonResponseDto();

        successResponse.setStatusCode(HttpStatus.CREATED.value());
        successResponse.setMessage("Role created successfully...");
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<JsonResponseDto> updateRole(@PathVariable Integer id, @RequestBody RoleDto roleDto) {
       
        roleService.updateRole(id, roleDto);
        
        JsonResponseDto successResponse = new JsonResponseDto();
        successResponse.setStatusCode(HttpStatus.CREATED.value());
        successResponse.setMessage("Role updated successfully");

        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<JsonResponseDto> deleteRole(@PathVariable Integer id) {
        roleService.deleteRole(id);

        JsonResponseDto successResponse = new JsonResponseDto();
        successResponse.setStatusCode(HttpStatus.OK.value());
        successResponse.setMessage("Role deleted successfully");

        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}
