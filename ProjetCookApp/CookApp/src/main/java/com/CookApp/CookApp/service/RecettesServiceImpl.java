package com.CookApp.CookApp.service;

import com.CookApp.CookApp.bdd.Recettes;
import com.CookApp.CookApp.repository.RecettesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RecettesServiceImpl implements RecettesService{

    private final RecettesRepository recettesRepository;
    @Override
    public Recettes creer(Recettes recettes) {
        return recettesRepository.save(recettes);
    }

    @Override
    public List<Recettes> lire() {
        return recettesRepository.findAll();
    }

    @Override
    public Recettes modifier(Long id, Recettes recettes) {
        return recettesRepository.findById(id)
                .map(r-> {
                    r.setNom(recettes.getNom());
                    r.setDescription(recettes.getDescription());
                    r.setRecette(recettes.getRecette());
                    r.setIngredients(recettes.getIngredients());
                    return recettesRepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Recette non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        recettesRepository.deleteById(id);
        return "Recette supprimer!";
    }
}
