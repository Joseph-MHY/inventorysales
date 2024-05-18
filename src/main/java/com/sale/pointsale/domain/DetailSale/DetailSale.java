package com.sale.pointsale.domain.DetailSale;

import com.sale.pointsale.domain.Sales.Sales;
import com.sale.pointsale.domain.Products.Products;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "detail_sale")
public class DetailSale {
    @EmbeddedId
    private DetailSaleId id;

    @MapsId("idProduct")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product", nullable = false)
    private Products idProduct;

    @MapsId("idSale")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_sale", nullable = false)
    private Sales idSale;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 1)
    private BigDecimal unitPrice;

    @Column(name = "total", nullable = false, precision = 10, scale = 1)
    private BigDecimal total;

}