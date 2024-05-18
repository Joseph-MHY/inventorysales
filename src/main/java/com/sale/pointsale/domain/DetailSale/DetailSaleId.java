package com.sale.pointsale.domain.DetailSale;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class DetailSaleId implements java.io.Serializable {
    private static final long serialVersionUID = -8288414759456364749L;
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    @Column(name = "id_sale", nullable = false)
    private Integer idSale;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DetailSaleId entity = (DetailSaleId) o;
        return Objects.equals(this.idSale, entity.idSale) &&
                Objects.equals(this.idProduct, entity.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSale, idProduct);
    }

}