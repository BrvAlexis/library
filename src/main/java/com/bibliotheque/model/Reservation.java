package com.bibliotheque.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Livre livre;
    
    @ManyToOne
    private Utilisateur utilisateur;
    
    private LocalDate dateReservation;

    // Getters et Setters
    // ...
} 