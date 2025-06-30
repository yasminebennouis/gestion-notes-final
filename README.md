# Gestion Notes - Application JavaFX

## Description

Cette application permet de gérer les notes des étudiants, les modules, sous-modules, promotions, utilisateurs et les statistiques associées.  
Elle est développée en Java avec JavaFX pour l'interface graphique, Maven pour la gestion des dépendances, et MySQL comme base de données.

---

## Fonctionnalités principales

- Gestion des utilisateurs avec rôles (`ADMIN`, `ENSEIGNANT`, `RESPONSABLE`)
- Gestion des étudiants, modules, sous-modules, promotions
- Saisie et import des notes (via fichiers Excel)
- Consultation des résultats individuels et tableaux récapitulatifs
- Statistiques sur les moyennes et classement des étudiants
- Authentification sécurisée avec rôle utilisateur

---

## Prérequis

- Java 17
- Maven 3.x
- MySQL (base de données `gestion_notes` configurée)
- IDE recommandé : IntelliJ IDEA

---

## Installation & lancement

1. **Cloner le dépôt**

```bash
git clone https://github.com/yasminebennouis/gestion-notes-final.git
cd gestion-notes-final
