package com.CookApp.CookApp.bdd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String mdp;
    @Column(length = 30)
    private String nom;
    private Boolean admin = false;
}
