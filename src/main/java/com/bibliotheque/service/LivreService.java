package com.bibliotheque.service;

import com.bibliotheque.model.Livre;
import com.bibliotheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public List<Livre> rechercherLivres(String titre, String auteur, String genre) {
        if (titre != null && !titre.isEmpty()) {
            return livreRepository.findByTitreContainingIgnoreCase(titre);
        } else if (auteur != null && !auteur.isEmpty()) {
            return livreRepository.findByAuteurContainingIgnoreCase(auteur);
        } else if (genre != null && !genre.isEmpty()) {
            return livreRepository.findByGenreContainingIgnoreCase(genre);
        }
        return livreRepository.findAll();
    }

    public Livre reserverLivre(Long livreId, Utilisateur utilisateur) {
        Livre livre = livreRepository.findById(livreId).orElseThrow(() -> new RuntimeException("Livre non trouvé"));
        if (!livre.isDisponible()) {
            throw new RuntimeException("Livre déjà réservé");
        }
        livre.setDisponible(false);
        livreRepository.save(livre);
        // Création de la réservation
        // ...
        return livre;
    }

    // Autres méthodes
    // ...
} 