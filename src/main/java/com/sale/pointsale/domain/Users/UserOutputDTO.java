package com.sale.pointsale.domain.Users;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOutputDTO {

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String surname;

    private BigDecimal salary;

    @NotBlank
    @Email(message = "email no válido")
    @Size(max = 80)
    private String emailUser;

    @NotBlank
    @Size(max = 10)
    @Pattern(regexp = "^(MASCULINO|FEMENINO|OTRO)$", message = "El género debe ser MASCULINO, FEMENINO u OTRO")
    private String gender;

    @NotNull
    @PositiveOrZero(message = "El id de documento debe ser mayor o igual que cero")
    private Integer idTypeDocument;

    @NotBlank
    @Size(max = 15)
    private String numDocument;

    @Size(min = 9, max = 9)
    private String telephone;

    @Size(min = 9, max = 9)
    private String mobile;

    @NotBlank
    @Size(max = 40)
    private String username;

    @NotBlank
    @Size(min = 5,max = 20, message = "la contraseña debe tener como minimo 5 dígitos")
    private String password;

    @NotNull
    @PositiveOrZero(message = "El rol debe existir y no puede ser negativo")
    private Integer idRole;
}
