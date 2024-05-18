package com.sale.pointsale.domain.Roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolesInputDTO {

    private Integer id;
    private String nameRole;
    private String description;
}
