package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner sc = new Scanner(System.in);
        boolean quitter = false;

        // Quelques données de test pour voir le résultat immédiatement (Optionnel)
        tracker.addExpenses(new Expenses(500, "Essence", LocalDate.of(2026, 2, 1)));
        tracker.addExpenses(new Expenses(300, "Reparation", LocalDate.of(2026, 2, 5)));
        tracker.addExpenses(new Expenses(200, "Assurance", LocalDate.of(2026, 2, 10)));

        while (!quitter) {
            System.out.println("\n--- MENU UBER EXPENSES ---");
            System.out.println("1. Ajouter dépense");
            System.out.println("2. Afficher toutes les dépenses");
            System.out.println("3. Supprimer une dépense");
            System.out.println("4. RÉCAPITULATIF AVEC % (Par catégorie)");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.print("Montant : ");
                    double m = sc.nextDouble(); sc.nextLine();
                    System.out.print("Catégorie : ");
                    String c = sc.nextLine();
                    tracker.addExpenses(new Expenses(m, c, LocalDate.now()));
                    break;
                case 2:
                    tracker.afficherTout();
                    break;
                case 3:
                    System.out.print("Index à supprimer : ");
                    tracker.deleteExpenses(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Entrez le mois (1-12) : ");
                    int mois = sc.nextInt();
                    tracker.afficherTotalParCategorie(2026, mois);
                    break;
                case 5:
                    quitter = true;
                    break;
            }
        }
        sc.close();
    }
}