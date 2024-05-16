package com.sale.pointsale.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('clients_id_client_seq'::regclass)")
    @Column(name = "id_client", nullable = false)
    private Integer id;

    @Column(name = "fullname", nullable = false, length = 50)
    private String fullname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_document")
    private IdentityDocuments idTypeDocument;

    @Column(name = "num_document", length = 15)
    private String numDocument;

    @Column(name = "telephone", length = 9)
    private String telephone;

    @Column(name = "mobile", length = 9)
    private String mobile;

    @Column(name = "address", length = Integer.MAX_VALUE)
    private String address;

    @Column(name = "creation_date")
    private Date creationDate;

    @OneToMany(mappedBy = "idClient")
    private Set<Sales> sales = new LinkedHashSet<>();

}