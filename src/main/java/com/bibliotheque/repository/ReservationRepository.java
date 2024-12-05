package com.bibliotheque.repository;

import com.bibliotheque.model.Reservation;
import com.bibliotheque.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUtilisateur(Utilisateur utilisateur);
} 