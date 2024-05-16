package com.sale.pointsale.service;

import com.sale.pointsale.models.DTO.input.UserInputDTO;
import com.sale.pointsale.models.DTO.output.UserOutputDTO;

public interface UserService {
    UserInputDTO printUser(UserOutputDTO userOutputDTO);
}
