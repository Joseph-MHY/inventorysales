package com.sale.pointsale.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('payment_method_id_method_seq'::regclass)")
    @Column(name = "id_method", nullable = false)
    private Integer id;

    @Column(name = "name_method", nullable = false, length = 50)
    private String nameMethod;

    @OneToMany(mappedBy = "idMethod")
    private Set<Sales> sales = new LinkedHashSet<>();

}