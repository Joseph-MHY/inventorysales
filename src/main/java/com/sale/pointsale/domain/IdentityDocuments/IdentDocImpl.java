package com.sale.pointsale.domain.IdentityDocuments;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IdentDocImpl implements IdentityDocumentService {

    @Autowired
    private IdentityDocumentsRepository iDocumentsRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public IdentityDocumentsInputDTO getDocumentById(Integer id) {
        IdentityDocuments doc = iDocumentsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Documento de identidad no encontrado"));
        return modelMapper.map(doc, IdentityDocumentsInputDTO.class);
    }

    @Override
    public IdentityDocumentsInputDTO saveDocument(IdentityDocumentsOutputDTO document) {
        IdentityDocuments doc = modelMapper.map(document, IdentityDocuments.class);
        doc.setId(null);
        IdentityDocuments saved = iDocumentsRepository.save(doc);
        return modelMapper.map(saved, IdentityDocumentsInputDTO.class);
    }

    @Override
    public List<IdentityDocumentsInputDTO> getAllDocuments() {
        List<IdentityDocuments> docs = iDocumentsRepository.findAll();
        return docs.stream()
                .map(doc -> modelMapper.map(doc, IdentityDocumentsInputDTO.class))
                .collect(Collectors.toList());
    }
}
