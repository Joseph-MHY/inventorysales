package com.sale.pointsale.service;

import com.sale.pointsale.models.DTO.input.IdentityDocumentsInputDTO;
import com.sale.pointsale.models.DTO.output.IdentityDocumentsOutputDTO;

import java.util.List;

public interface IdentityDocumentService {
    IdentityDocumentsInputDTO getDocumentById(Integer id);
    IdentityDocumentsInputDTO saveDocument(IdentityDocumentsOutputDTO document);
    List<IdentityDocumentsInputDTO> getAllDocuments();
}
