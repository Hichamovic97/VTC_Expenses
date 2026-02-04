package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseTracker {
    private List<Expenses> depenses = new ArrayList<>();
    private List<Revenue> revenus = new ArrayList<>();

    public void addExpense(Expenses e) { depenses.add(e); }

    public void addRevenue(double montant, int mois) {
        revenus.add(new Revenue(montant, java.time.LocalDate.of(2026, mois, 1)));
    }

    public void modifierRevenue(int index, double nouveauMontant) {
        if (index >= 0 && index < revenus.size()) {
            revenus.get(index).setMontant(nouveauMontant);
        }
    }

    public void afficherTousRevenus() {
        if (revenus.isEmpty()) System.out.println("Aucun revenu.");
        for (int i = 0; i < revenus.size(); i++) {
            System.out.println(i + " - " + revenus.get(i));
        }
    }

    public void deleteExpense(int index) {
        if (index >= 0 && index < depenses.size()) depenses.remove(index);
    }

    public void afficherToutesDepenses() {
        for (int i = 0; i < depenses.size(); i++) System.out.println(i + " - " + depenses.get(i));
    }

    public void afficherBilanMensuel(int annee, int mois) {
        double totalRevenus = revenus.stream()
                .filter(r -> r.getDate().getYear() == annee && r.getDate().getMonthValue() == mois)
                .mapToDouble(Revenue::getMontant).sum();

        double sommeDepenses = 0; // Variable temporaire pour le calcul
        Map<String, Double> parCat = new HashMap<>();

        for (Expenses e : depenses) {
            if (e.getDate().getYear() == annee && e.getDate().getMonthValue() == mois) {
                sommeDepenses += e.getMontant();
                String nomCat = (e.getCategorie() == Categorie.AUTRE) ? e.getCommentaire() : e.getCategorie().getNom();
                parCat.put(nomCat, parCat.getOrDefault(nomCat, 0.0) + e.getMontant());
            }
        }

        final double totalFinalDepenses = sommeDepenses; // On crée une variable finale pour la Lambda

        System.out.println("\n===== BILAN UBER PRO " + mois + "/" + annee + " =====");
        System.out.printf("REVENUS : %.2f$ | DÉPENSES : %.2f$ | NET : %.2f$\n", totalRevenus, totalFinalDepenses, (totalRevenus - totalFinalDepenses));

        if (totalFinalDepenses > 0) {
            parCat.forEach((cat, val) -> {
                double pct = (val / totalFinalDepenses) * 100;
                System.out.printf("- %s : %.2f$ (%.1f%%)\n", cat, val, pct);
            });
        }
    }
}