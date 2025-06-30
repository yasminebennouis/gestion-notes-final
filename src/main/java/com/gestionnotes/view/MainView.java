package com.gestionnotes.view;

import com.gestionnotes.model.Utilisateur;
import com.gestionnotes.service.StatistiquesService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

    private final Stage stage;
    private final Utilisateur utilisateur;

    public MainView(Stage stage, Utilisateur utilisateur) {
        this.stage = stage;
        this.utilisateur = utilisateur;
        afficherMenuPrincipal();
    }

    public void afficherMenuPrincipal() {
        Label bienvenue = new Label("👋 Bienvenue, " + utilisateur.getNom().toUpperCase() + " (" + utilisateur.getRole() + ")");
        bienvenue.getStyleClass().add("title");

        VBox menuBox = new VBox(15);
        menuBox.setAlignment(Pos.CENTER);

        String role = utilisateur.getRole();

        // ADMIN : accès complet
        if (role.equalsIgnoreCase("ADMIN")) {
            ajouterBoutonsAdmin(menuBox);
        }
        // ENSEIGNANT : accès à la gestion des notes, sous-modules et résultats
        else if (role.equalsIgnoreCase("ENSEIGNANT")) {
            ajouterBoutonsEnseignant(menuBox);
        }
        // RESPONSABLE : accès aux statistiques et planning
        else if (role.equalsIgnoreCase("RESPONSABLE")) {
            ajouterBoutonsResponsable(menuBox);
        }

        Button btnLogout = new Button("🚪 Déconnexion");
        btnLogout.setOnAction(e -> {
            LoginView loginView = new LoginView(new com.gestionnotes.service.UtilisateurService());
            loginView.afficher(stage);
        });

        menuBox.getChildren().add(btnLogout);

        VBox root = new VBox(30, bienvenue, menuBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));

        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("🏠 Menu Principal - Gestion des Notes");
        stage.show();
    }

    private void ajouterBoutonsAdmin(VBox menuBox) {
        Button btnGestionNotes = new Button("📝 Gestion des Notes");
        btnGestionNotes.setOnAction(e -> new NoteView(new com.gestionnotes.service.NoteService(), utilisateur).show(stage));

        Button btnGestionModules = new Button("📘 Gestion des Modules");
        btnGestionModules.setOnAction(e -> new ModuleView(new com.gestionnotes.service.ModuleService(), utilisateur).show(stage));

        Button btnGestionSousModules = new Button("📗 Gestion des Sous-Modules");
        btnGestionSousModules.setOnAction(e -> new SousModuleView(new com.gestionnotes.service.SousModuleService(), utilisateur).show(stage));

        Button btnGestionPromotions = new Button("🎓 Gestion des Promotions");
        btnGestionPromotions.setOnAction(e -> new PromotionView(new com.gestionnotes.service.PromotionService(), utilisateur).show(stage));

        Button btnResultatsEtudiant = new Button("📄 Résultats Étudiant");
        btnResultatsEtudiant.setOnAction(e -> new ResultatsEtudiantView(utilisateur).start(stage));

        Button btnStatistiques = new Button("📊 Statistiques");
        btnStatistiques.setOnAction(e -> new StatistiquesView(new StatistiquesService(), utilisateur).show(stage));

        Button btnTableauClasse = new Button("📋 Tableau Récapitulatif Classe");
        btnTableauClasse.setOnAction(e -> new TableauRecapitulatifView(utilisateur).show(stage));

        menuBox.getChildren().addAll(
                btnGestionNotes,
                btnGestionModules,
                btnGestionSousModules,
                btnGestionPromotions,
                btnResultatsEtudiant,
                btnStatistiques,
                btnTableauClasse
        );
    }

    private void ajouterBoutonsEnseignant(VBox menuBox) {
        Button btnGestionNotes = new Button("📝 Gestion des Notes");
        btnGestionNotes.setOnAction(e -> new NoteView(new com.gestionnotes.service.NoteService(), utilisateur).show(stage));

        Button btnGestionSousModules = new Button("📗 Gestion des Sous-Modules");
        btnGestionSousModules.setOnAction(e -> new SousModuleView(new com.gestionnotes.service.SousModuleService(), utilisateur).show(stage));

        Button btnResultatsEtudiant = new Button("📄 Résultats Étudiant");
        btnResultatsEtudiant.setOnAction(e -> new ResultatsEtudiantView(utilisateur).start(stage));

        menuBox.getChildren().addAll(
                btnGestionNotes,
                btnGestionSousModules,
                btnResultatsEtudiant
        );
    }

    private void ajouterBoutonsResponsable(VBox menuBox) {
        Button btnStatistiques = new Button("📊 Statistiques");
        btnStatistiques.setOnAction(e -> new StatistiquesView(new StatistiquesService(), utilisateur).show(stage));

        Button btnTableauClasse = new Button("📋 Tableau Récapitulatif Classe");
        btnTableauClasse.setOnAction(e -> new TableauRecapitulatifView(utilisateur).show(stage));

        menuBox.getChildren().addAll(
                btnStatistiques,
                btnTableauClasse
        );
    }
}