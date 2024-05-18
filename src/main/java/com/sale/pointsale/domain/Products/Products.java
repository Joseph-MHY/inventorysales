package com.sale.pointsale.domain.Products;

import com.sale.pointsale.domain.Categories.Categories;
import com.sale.pointsale.domain.DetailSale.DetailSale;
import com.sale.pointsale.domain.Suppliers.Suppliers;
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
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('products_id_product_seq'::regclass)")
    @Column(name = "id_product", nullable = false)
    private Integer id;

    @Column(name = "name_product", nullable = false, length = 80)
    private String nameProduct;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name = "stock_minimum", nullable = false)
    private Integer stockMinimum;

    @Column(name = "current_stock", nullable = false)
    private Integer currentStock;

    @Column(name = "bar_code", nullable = false, length = 15)
    private String barCode;

    @Column(name = "price_in", nullable = false, precision = 10, scale = 1)
    private BigDecimal priceIn;

    @Column(name = "price_out", nullable = false, precision = 10, scale = 1)
    private BigDecimal priceOut;

    @Column(name = "utility", nullable = false, precision = 10, scale = 1)
    private BigDecimal utility;

    @Column(name = "image", nullable = false, length = Integer.MAX_VALUE)
    private String image;

    @Column(name = "state", nullable = false)
    private Boolean state = false;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    private Categories idCategory;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_supplier", nullable = false)
    private Suppliers idSupplier;

    @OneToMany(mappedBy = "idProduct")
    private Set<DetailSale> detailSales = new LinkedHashSet<>();

}