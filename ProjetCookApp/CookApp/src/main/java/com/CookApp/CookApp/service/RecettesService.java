package com.CookApp.CookApp.service;

import com.CookApp.CookApp.bdd.Recettes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecettesService {

    Recettes creer(Recettes recettes);

    List<Recettes> lire();

    Recettes modifier(Long id, Recettes recettes);

    String supprimer(Long id);
}