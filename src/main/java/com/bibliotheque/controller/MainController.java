package com.bibliotheque.controller;

import com.bibliotheque.model.Livre;
import com.bibliotheque.service.LivreService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MainController {

    @Autowired
    private LivreService livreService;

    @FXML
    private TextField titreField;
    @FXML
    private TextField auteurField;
    @FXML
    private TextField genreField;
    @FXML
    private TableView<Livre> livreTable;
    @FXML
    private TableColumn<Livre, Long> idColumn;
    @FXML
    private TableColumn<Livre, String> titreColumn;
    @FXML
    private TableColumn<Livre, String> auteurColumn;
    @FXML
    private TableColumn<Livre, String> genreColumn;
    @FXML
    private TableColumn<Livre, Boolean> disponibleColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        titreColumn.setCellValueFactory(cellData -> cellData.getValue().titreProperty());
        auteurColumn.setCellValueFactory(cellData -> cellData.getValue().auteurProperty());
        genreColumn.setCellValueFactory(cellData -> cellData.getValue().genreProperty());
        disponibleColumn.setCellValueFactory(cellData -> cellData.getValue().disponibleProperty());

        // Charger tous les livres au démarrage
        chargerLivres();
    }

    @FXML
    private void handleRechercher() {
        String titre = titreField.getText();
        String auteur = auteurField.getText();
        String genre = genreField.getText();
        List<Livre> livres = livreService.rechercherLivres(titre, auteur, genre);
        livreTable.getItems().setAll(livres);
    }

    private void chargerLivres() {
        List<Livre> livres = livreService.rechercherLivres(null, null, null);
        livreTable.getItems().setAll(livres);
    }

    // Autres méthodes pour réserver, gérer les utilisateurs, etc.
    // ...
} 