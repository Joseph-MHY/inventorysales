package com.sale.pointsale.controller;

import com.sale.pointsale.domain.IdentityDocuments.IdentityDocumentsInputDTO;
import com.sale.pointsale.domain.IdentityDocuments.IdentDocImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/docs")
public class IdentDocsController {

    @Autowired
    private IdentDocImpl identDoc;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<IdentityDocumentsInputDTO> getAllIdentityDocuments() {
        return identDoc.getAllDocuments();
    }
}
