package org.example;
import java.time.LocalDate;

public class Expenses {
    private double montant;
    private Categorie categorie;
    private String commentaire;
    private LocalDate date;

    public Expenses(double montant, Categorie categorie, String commentaire, LocalDate date) {
        this.montant = montant;
        this.categorie = categorie;
        this.commentaire = commentaire;
        this.date = date;
    }

    public double getMontant() { return montant; }
    public Categorie getCategorie() { return categorie; }
    public String getCommentaire() { return commentaire; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        String catNom = (categorie == Categorie.AUTRE) ? commentaire : categorie.getNom();
        return date + " | " + catNom + " | " + montant + "$";
    }
}