package com.sale.pointsale.domain.Suppliers;

import jakarta.validation.constraints.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierOutputDTO {

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    @Size(max = 200, message = "El nombre del proveedor no puede tener más de 200 caracteres")
    private String nameSupplier;

    @NotNull(message = "El tipo de documento es obligatorio")
    private Integer idTypeDocument;

    @NotBlank(message = "El número de documento es obligatorio")
    @Size(max = 15, message = "El número de documento no puede tener más de 15 caracteres")
    private String numDocument;

    private Boolean state = false;

    @Size(min = 9, max = 9, message = "El teléfono debe tener exactamente 9 caracteres")
    private String telephone;

    @Size(min = 9, max = 9, message = "El móvil debe tener exactamente 9 caracteres")
    private String mobile;

    @Size(max = 80, message = "El correo electrónico no puede tener más de 80 caracteres")
    @Email(message = "Correo electrónico no válido")
    private String emailSupplier;

    @Size(max = 25, message = "El número de cuenta no puede tener más de 25 caracteres")
    private String numberAccount;
    private String pageWeb;
    private String addressSup;
    private Date creationDate;
}
