package org.example;

import java.time.LocalDate;

public class Expenses {
    private double montant;
    private String categorie;
    private LocalDate date;

    public Expenses(double montant, String categorie, LocalDate date) {
        if (montant < 0) {
            throw new IllegalArgumentException("Le montant ne peut pas être négatif.");
        }
        this.montant = montant;
        this.categorie = categorie;
        this.date = date;
    }

    public double getMontant() { return montant; }
    public String getCategorie() { return categorie; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return date + " | " + categorie + " | " + montant + "$";
    }
}