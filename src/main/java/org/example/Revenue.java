package org.example;
import java.time.LocalDate;

public class Revenue {
    private double montant;
    private LocalDate date;

    public Revenue(double montant, LocalDate date) {
        this.montant = montant;
        this.date = date;
    }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; } // Permet la modification
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return date + " | Gain Uber : " + montant + "$";
    }
}