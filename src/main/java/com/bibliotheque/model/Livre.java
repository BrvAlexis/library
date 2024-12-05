package com.bibliotheque.model;

import javax.persistence.*;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titre;
    private String auteur;
    private String genre;
    private boolean disponible;

    // Getters et Setters
    // ...
} 