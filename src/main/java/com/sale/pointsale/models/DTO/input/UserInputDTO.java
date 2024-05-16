package com.sale.pointsale.models.DTO.input;

import com.sale.pointsale.models.entity.IdentityDocuments;
import com.sale.pointsale.models.entity.Roles;
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
public class UserInputDTO {

    private Integer id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private String emailUser;
    private String gender;
    private IdentityDocumentsInputDTO TypeDocument;
    private String numDocument;
    private Boolean state;
    private String telephone;
    private String mobile;
    private String username;
    private String password;
    private RolesInputDTO Role;
    private Date creationDate;
}
