package com.sale.pointsale.models.entity;

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
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('users_id_user_seq'::regclass)")
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "salary", nullable = false, precision = 10, scale = 1)
    private BigDecimal salary;

    @Column(name = "email_user", nullable = false, length = 80)
    private String emailUser;

    @Column(name = "gender", length = 10)
    private String gender;

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

    @Column(name = "username", nullable = false, length = 40)
    private String username;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_role", nullable = false)
    private Roles idRole;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @OneToMany(mappedBy = "idUser")
    private Set<Sales> sales = new LinkedHashSet<>();

}