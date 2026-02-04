package org.example;

public enum Categorie {
    ESSENCE("Essence"),
    ENTRETIEN("Entretien/Réparation"),
    ASSURANCE("Assurance"),
    LAVAGE("Lavage"),
    REPAS("Repas/Café"),
    AUTRE("Autre");

    private final String nom;
    Categorie(String nom) { this.nom = nom; }
    public String getNom() { return nom; }
}