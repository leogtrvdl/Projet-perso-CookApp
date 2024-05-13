package com.CookApp.CookApp.api.repository;

import com.CookApp.CookApp.bdd.Recettes;
import com.CookApp.CookApp.repository.RecettesRepository;
import com.CookApp.CookApp.service.RecettesServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecettesRepositoryTests {

    @Autowired
    private RecettesRepository recettesRepository;

    @Test
    public void RecettesRepository_Creer_ReturnCreatedRecettes() {

        //Arrange
        Recettes recette = new Recettes("Riz","Recette de riz","rice cooker","riz");
        //Act
        Recettes createdRecette = recettesRepository.save(recette);
        //Assert
        Assertions.assertNotNull(createdRecette);

        //Reset
        recettesRepository.deleteById(recette.getId());
        Optional<Recettes> recetteReturn = recettesRepository.findById(recette.getId());
    }

    @Test
    public void RecettesRepository_CheckAll_ReturnExpectedData() {

        //Arrange
        Recettes recette = new Recettes("Riz","Recette de riz","rice cooker","riz");
        //Act
        Recettes createdRecette = recettesRepository.save(recette);
        //Assert
        Assertions.assertEquals("Riz", createdRecette.getNom());
        Assertions.assertEquals("Recette de riz", createdRecette.getDescription());
        Assertions.assertEquals("rice cooker", createdRecette.getRecette());
        Assertions.assertEquals("riz", createdRecette.getIngredients());

        //Reset
        recettesRepository.deleteById(recette.getId());
        Optional<Recettes> recetteReturn = recettesRepository.findById(recette.getId());
    }

    @Test
    public void RecettesRepository_GetAll_ReturnMoreThenOneRecette() {

        //Arrange
        Recettes recette = new Recettes("Riz","Recette de riz","rice cooker","riz");
        Recettes recette2 = new Recettes("Pâtes","Recette de Pâtes","a l'eau","pâtes");

        recettesRepository.save(recette);
        recettesRepository.save(recette2);

        //Act
        List<Recettes> recettesList = recettesRepository.findAll();

        //Assert
        Assertions.assertNotNull(recettesList);
        Assertions.assertEquals(2, recettesList.size());

        //Reset
        recettesRepository.deleteById(recette.getId());
        recettesRepository.deleteById(recette2.getId());
    }

    @Test
    public void RecettesRepository_FindByIngredients_ReturnAllByIngredients() {

        //Arrange
        Recettes recette = new Recettes("Riz","Recette de riz","rice cooker","riz");
        recettesRepository.save(recette);

        //Act
        Recettes recettesList = recettesRepository.findByIngredients(recette.getIngredients()).get();

        //Assert
        Assertions.assertNotNull(recettesList);

        //Reset
        recettesRepository.deleteById(recette.getId());
        Optional<Recettes> recetteReturn = recettesRepository.findById(recette.getId());
    }

    @Test
    public void RecettesRepository_DeleteById_ReturnRecetteIsEmpty() {

        //Arrange
        Recettes recette = new Recettes("Riz a delete","Recette de riz","rice cooker","riz");
        recettesRepository.save(recette);

        //Act
        recettesRepository.deleteById(recette.getId());
        Optional<Recettes> recetteReturn = recettesRepository.findById(recette.getId());

        //Assert
        Assertions.assertEquals(Optional.empty(), recetteReturn);
    }
}