package com.sale.pointsale.domain.Roles;

import com.sale.pointsale.domain.Users.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('roles_id_role_seq'::regclass)")
    @Column(name = "id_role", nullable = false)
    private Integer id;

    @Column(name = "name_role", nullable = false, length = 40)
    private String nameRole;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @OneToMany(mappedBy = "idRole")
    private Set<Users> users = new LinkedHashSet<>();

}