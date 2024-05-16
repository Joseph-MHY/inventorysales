package com.sale.pointsale.controller;

import com.sale.pointsale.models.DTO.input.RolesInputDTO;
import com.sale.pointsale.models.DTO.output.RolesOutputDTO;
import com.sale.pointsale.service.RoleService;
import com.sale.pointsale.service.impl.RoleServiceImpl;
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
    public ResponseEntity<RolesInputDTO> saveRole(@RequestBody RolesOutputDTO roleInputDTO) {
        RolesInputDTO savedRole = roleService.saveRole(roleInputDTO);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RolesInputDTO>> getAllRoles() {
        List<RolesInputDTO> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesInputDTO> getRoleById(@PathVariable Integer id) {
        RolesInputDTO role = roleService.getRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
