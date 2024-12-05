package com.bibliotheque.service;

import com.bibliotheque.model.Livre;
import com.bibliotheque.repository.LivreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LivreServiceTest {

    @Mock
    private LivreRepository livreRepository;

    @InjectMocks
    private LivreService livreService;

    @Test
    public void testReserverLivre_Disponible() {
        Livre livre = new Livre();
        livre.setId(1L);
        livre.setDisponible(true);
        
        when(livreRepository.findById(1L)).thenReturn(Optional.of(livre));
        when(livreRepository.save(any(Livre.class))).thenReturn(livre);
        
        Livre reserver = livreService.reserverLivre(1L, null);
        
        assertFalse(reserver.isDisponible());
        verify(livreRepository, times(1)).save(livre);
    }

    @Test
    public void testReserverLivre_Indisponible() {
        Livre livre = new Livre();
        livre.setId(1L);
        livre.setDisponible(false);
        
        when(livreRepository.findById(1L)).thenReturn(Optional.of(livre));
        
        Exception exception = assertThrows(RuntimeException.class, () -> {
            livreService.reserverLivre(1L, null);
        });
        
        String expectedMessage = "Livre déjà réservé";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Autres tests
    // ...
} 