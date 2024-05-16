package com.sale.pointsale.controller;

import com.sale.pointsale.models.DTO.input.UserInputDTO;
import com.sale.pointsale.models.DTO.output.UserOutputDTO;
import com.sale.pointsale.service.UserService;
import com.sale.pointsale.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/print")
    public ResponseEntity<UserInputDTO> print(@RequestBody UserOutputDTO userOutputDTO) {
        UserInputDTO user = userService.printUser(userOutputDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
