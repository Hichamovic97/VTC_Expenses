package org.example;
import java.time.LocalDate;
public class Expenses {
    private double montant;
    private  String categorie;
    private  LocalDate date;

    /**
     * constructeur qui recois @montant,@categorie et @date comme params
     */
    Expenses(double montant, String categorie, LocalDate date) {
        if (montant < 0) {
            throw new IllegalArgumentException("Montant can't be negative");
        }
        this.montant = montant;
        this.categorie = categorie;
        this.date = date;
    }
// getters pour pouvoir utiliser les donnée plutard:
    public double getMontant() {return montant;}
    public String getCategorie() {return categorie;}
    public LocalDate getDate() {return date;}

    public String toString(){
        return date + " | "+ categorie+" | "+ montant;
    }
}
