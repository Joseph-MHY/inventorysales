package com.sale.pointsale.domain.Roles;

import java.util.List;

public interface RoleService {

    RolesInputDTO saveRole(RolesOutputDTO roleOutputDTO);
    List<RolesInputDTO> getAllRoles();
    RolesInputDTO getRoleById(Integer id);
}
