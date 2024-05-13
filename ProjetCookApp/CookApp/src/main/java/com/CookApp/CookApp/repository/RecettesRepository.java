package com.CookApp.CookApp.repository;

import com.CookApp.CookApp.bdd.Recettes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecettesRepository extends JpaRepository<Recettes, Long> {
    Optional<Recettes> findByIngredients(String ingredients);
}
