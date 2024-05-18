package com.sale.pointsale.domain.TypeSaleDocuments;

import com.sale.pointsale.domain.Sales.Sales;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "type_saledocument")
public class TypeSaledocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('type_saledocument_id_document_seq'::regclass)")
    @Column(name = "id_document", nullable = false)
    private Integer id;

    @Column(name = "name_saledoc", nullable = false, length = 50)
    private String nameSaledoc;

    @OneToMany(mappedBy = "idDocument")
    private Set<Sales> sales = new LinkedHashSet<>();

}