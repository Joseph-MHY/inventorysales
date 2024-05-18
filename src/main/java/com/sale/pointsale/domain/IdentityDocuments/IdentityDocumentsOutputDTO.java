package com.sale.pointsale.domain.IdentityDocuments;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentityDocumentsOutputDTO {

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String nameDocument;
}
