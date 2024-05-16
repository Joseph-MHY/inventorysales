package com.sale.pointsale.service;

import com.sale.pointsale.models.DTO.input.RolesInputDTO;
import com.sale.pointsale.models.DTO.output.RolesOutputDTO;
import com.sale.pointsale.models.entity.Roles;

import java.util.List;

public interface RoleService {

    RolesInputDTO saveRole(RolesOutputDTO roleOutputDTO);
    List<RolesInputDTO> getAllRoles();
    RolesInputDTO getRoleById(Integer id);
}
