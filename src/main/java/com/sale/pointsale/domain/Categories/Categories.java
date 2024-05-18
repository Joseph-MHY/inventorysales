package com.sale.pointsale.domain.Categories;

import com.sale.pointsale.domain.Products.Products;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('categories_id_category_seq'::regclass)")
    @Column(name = "id_category", nullable = false)
    private Integer id;

    @Column(name = "name_category", nullable = false, length = 50)
    private String nameCategory;

    @OneToMany(mappedBy = "idCategory")
    private Set<Products> products = new LinkedHashSet<>();

}