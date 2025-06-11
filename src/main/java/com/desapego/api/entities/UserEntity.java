package com.desapego.api.entities;

import jakarta.persistence.*;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name = "telephoneNumber")
    private String telephoneNumber;
}
