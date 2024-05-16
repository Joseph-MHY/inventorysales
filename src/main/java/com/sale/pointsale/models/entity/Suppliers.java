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
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('suppliers_id_supplier_seq'::regclass)")
    @Column(name = "id_supplier", nullable = false)
    private Integer id;

    @Column(name = "name_supplier", nullable = false, length = 200)
    private String nameSupplier;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_document", nullable = false)
    private IdentityDocuments idTypeDocument;

    @Column(name = "num_document", nullable = false, length = 15)
    private String numDocument;

    @Column(name = "state", nullable = false)
    private Boolean state = false;

    @Column(name = "telephone", length = 9)
    private String telephone;

    @Column(name = "mobile", length = 9)
    private String mobile;

    @Column(name = "email_supplier", length = 80)
    private String emailSupplier;

    @Column(name = "number_account", length = 25)
    private String numberAccount;

    @Column(name = "page_web", length = Integer.MAX_VALUE)
    private String pageWeb;

    @Column(name = "address_sup", length = Integer.MAX_VALUE)
    private String addressSup;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @OneToMany(mappedBy = "idSupplier")
    private Set<Products> products = new LinkedHashSet<>();

}