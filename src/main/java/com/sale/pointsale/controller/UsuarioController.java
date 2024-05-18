package com.sale.pointsale.controller;

import com.sale.pointsale.domain.Users.UserInputDTO;
import com.sale.pointsale.domain.Users.UserOutputDTO;
import com.sale.pointsale.domain.Users.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/print")
    @ResponseStatus(HttpStatus.CREATED)
    public UserInputDTO print(@Valid @RequestBody UserOutputDTO userOutputDTO) {
        return userService.printUser(userOutputDTO);
    }
}
