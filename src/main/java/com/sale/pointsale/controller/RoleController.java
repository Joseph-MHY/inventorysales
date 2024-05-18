package com.sale.pointsale.controller;

import com.sale.pointsale.domain.Roles.RolesInputDTO;
import com.sale.pointsale.domain.Roles.RolesOutputDTO;
import com.sale.pointsale.domain.Roles.RoleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public RolesInputDTO saveRole(@Valid @RequestBody RolesOutputDTO rolesOutputDTO) {
        return roleService.saveRole(rolesOutputDTO);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<RolesInputDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RolesInputDTO getRoleById(@PathVariable Integer id) {
        return roleService.getRoleById(id);
    }
}
