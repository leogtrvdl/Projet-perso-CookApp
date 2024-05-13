package com.CookApp.CookApp.bdd;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recettes")
@Getter
@Setter
@RequiredArgsConstructor
public class Recettes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String description;

    @Column(columnDefinition = "LONGTEXT")
    private String recette;

    @Column
    private String ingredients;

    public Recettes(String nom, String description, String recette, String ingredients) {
        this.nom = nom;
        this.description = description;
        this.recette = recette;
        this.ingredients = ingredients;
    }
}
