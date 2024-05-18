package com.sale.pointsale.domain.IdentityDocuments;

import java.util.List;

public interface IdentityDocumentService {
    IdentityDocumentsInputDTO getDocumentById(Integer id);
    IdentityDocumentsInputDTO saveDocument(IdentityDocumentsOutputDTO document);
    List<IdentityDocumentsInputDTO> getAllDocuments();
}
