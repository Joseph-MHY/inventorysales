package com.sale.pointsale.domain.Sales;

import com.sale.pointsale.domain.Users.Users;
import com.sale.pointsale.domain.Clients.Clients;
import com.sale.pointsale.domain.DetailSale.DetailSale;
import com.sale.pointsale.domain.PaymentMethod.PaymentMethod;
import com.sale.pointsale.domain.TypeSaleDocuments.TypeSaledocument;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('sales_id_sale_seq'::regclass)")
    @Column(name = "id_sale", nullable = false)
    private Integer id;

    @Column(name = "date_of_sale", nullable = false)
    private Date dateOfSale;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_document", nullable = false)
    private TypeSaledocument idDocument;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    private Clients idClient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private Users idUser;

    @Column(name = "subtotal", nullable = false, precision = 10, scale = 1)
    private BigDecimal subtotal;

    @Column(name = "igv", nullable = false, precision = 10, scale = 1)
    private BigDecimal igv;

    @Column(name = "discount", precision = 10, scale = 1)
    private BigDecimal discount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_method", nullable = false)
    private PaymentMethod idMethod;

    @Column(name = "total", nullable = false, precision = 10, scale = 1)
    private BigDecimal total;

    @OneToMany(mappedBy = "idSale")
    private Set<DetailSale> detailSales = new LinkedHashSet<>();

}