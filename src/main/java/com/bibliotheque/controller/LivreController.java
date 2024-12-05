package com.bibliotheque.controller;

import com.bibliotheque.model.Livre;
import com.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping("/rechercher")
    public List<Livre> rechercherLivres(
            @RequestParam(required = false) String titre,
            @RequestParam(required = false) String auteur,
            @RequestParam(required = false) String genre) {
        return livreService.rechercherLivres(titre, auteur, genre);
    }

    @PostMapping("/reserver")
    public Livre reserverLivre(@RequestParam Long livreId, @RequestParam Long utilisateurId) {
        // Appeler le service pour réserver le livre
        // ...
        return null;
    }

    // Autres endpoints
    // ...
} 