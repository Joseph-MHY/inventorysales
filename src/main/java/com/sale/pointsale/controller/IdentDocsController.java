package com.sale.pointsale.controller;

import com.sale.pointsale.models.DTO.input.IdentityDocumentsInputDTO;
import com.sale.pointsale.service.impl.IdentDocImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/docs")
public class IdentDocsController {

    @Autowired
    private IdentDocImpl identDoc;

    @GetMapping("/all")
    public ResponseEntity<List<IdentityDocumentsInputDTO>> getAllIdentityDocuments() {
        List<IdentityDocumentsInputDTO> docs = identDoc.getAllDocuments();
        return new ResponseEntity<>(docs , HttpStatus.OK);
    }
}
