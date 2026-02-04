package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseTracker {
    private List<Expenses> liste = new ArrayList<>();

    public void addExpenses(Expenses expenses) {
        liste.add(expenses);
        System.out.println("Ajouté !");
    }

    public void deleteExpenses(int index) {
        if (index >= 0 && index < liste.size()) liste.remove(index);
    }

    public void afficherTout() {
        for (int i = 0; i < liste.size(); i++) System.out.println(i + " - " + liste.get(i));
    }

    public void afficherTotalParCategorie(int annee, int mois) {
        Map<String, Double> totauxParCat = new HashMap<>();
        double totalGlobalMois = 0;

        // 1. On filtre et on cumule
        for (Expenses e : liste) {
            if (e.getDate().getYear() == annee && e.getDate().getMonthValue() == mois) {
                totauxParCat.put(e.getCategorie(), totauxParCat.getOrDefault(e.getCategorie(), 0.0) + e.getMontant());
                totalGlobalMois += e.getMontant();
            }
        }

        if (totalGlobalMois == 0) {
            System.out.println("Aucune donnée pour ce mois.");
            return;
        }

        // 2. Affichage avec calcul du pourcentage
        System.out.println("\n--- RÉCAPITULATIF DÉTAILLÉ (" + mois + "/" + annee + ") ---");
        System.out.println("Dépenses totales : " + totalGlobalMois + "$");
        System.out.println("------------------------------------------");

        for (Map.Entry<String, Double> entry : totauxParCat.entrySet()) {
            double montantCat = entry.getValue();
            double pourcentage = (montantCat / totalGlobalMois) * 100;

            // On affiche le nom, le montant et le % arrondi à une décimale
            System.out.printf("%s : %.2f$ (%.1f%% des dépenses)\n", entry.getKey(), montantCat, pourcentage);
        }
    }
}