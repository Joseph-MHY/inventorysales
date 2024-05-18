package com.sale.pointsale.domain.IdentityDocuments;

import com.sale.pointsale.domain.Clients.Clients;
import com.sale.pointsale.domain.Users.Users;
import com.sale.pointsale.domain.Suppliers.Suppliers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "identity_documents")
public class IdentityDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('identity_documents_id_type_document_seq'::regclass)")
    @Column(name = "id_type_document", nullable = false)
    private Integer id;

    @Column(name = "name_document", nullable = false, length = 50)
    private String nameDocument;

    @OneToMany(mappedBy = "idTypeDocument")
    private Set<Clients> clients = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTypeDocument")
    private Set<Suppliers> suppliers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTypeDocument")
    private Set<Users> users = new LinkedHashSet<>();

}