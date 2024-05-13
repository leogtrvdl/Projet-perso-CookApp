package com.CookApp.CookApp.controller;

import com.CookApp.CookApp.bdd.Recettes;
import com.CookApp.CookApp.service.RecettesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recettes")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class RecettesController {

    private final RecettesService recettesService;

    @PostMapping("/create")
    public Recettes create(@RequestBody Recettes recettes) {
        return recettesService.creer(recettes);
    }

    @GetMapping("/read")
    public List<Recettes> read() {
        return recettesService.lire();
    }

    @PutMapping("/update/{id}")
    public Recettes update(@PathVariable Long id, @RequestBody Recettes recettes) {
        return recettesService.modifier(id, recettes);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable Long id) {
        return recettesService.supprimer(id);
    }
}
