package com.sale.pointsale.models.DTO.output;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolesOutputDTO {

    @NotBlank(message = "el nombre del Rol es importante")
    @Size(max = 40)
    private String nameRole;

    @Size(max = Integer.MAX_VALUE)
    private String description;
}
