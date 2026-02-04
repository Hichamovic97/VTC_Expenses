package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner sc = new Scanner(System.in);
        boolean quitter = false;

        while (!quitter) {
            System.out.println("\n--- MENU UBER DASHBOARD ---");
            System.out.println("1. Ajouter un Revenu");
            System.out.println("2. MODIFIER un Revenu");
            System.out.println("3. Ajouter une Dépense");
            System.out.println("4. Supprimer une Dépense");
            System.out.println("5. Voir Bilan Complet");
            System.out.println("6. Quitter");
            System.out.print("Choix : ");

            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.print("Montant gain : ");
                    double rev = sc.nextDouble();
                    System.out.print("Mois (1-12) : ");
                    tracker.addRevenue(rev, sc.nextInt());
                    break;
                case 2:
                    tracker.afficherTousRevenus();
                    System.out.print("Index du revenu à modifier : ");
                    int idx = sc.nextInt();
                    System.out.print("Nouveau montant : ");
                    tracker.modifierRevenue(idx, sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Montant dépense : ");
                    double mDep = sc.nextDouble();
                    System.out.println("Catégorie : 1.Essence 2.Entretien 3.Assurance 4.Lavage 5.Repas 6.Autre");
                    int cIdx = sc.nextInt();
                    sc.nextLine(); // Nettoyage buffer

                    Categorie cat = Categorie.values()[cIdx - 1];
                    String comm = "";
                    if (cat == Categorie.AUTRE) {
                        System.out.print("Précisez la catégorie : ");
                        comm = sc.nextLine();
                    }
                    tracker.addExpense(new Expenses(mDep, cat, comm, LocalDate.now()));
                    break;
                case 4:
                    tracker.afficherToutesDepenses();
                    System.out.print("Index à supprimer : ");
                    tracker.deleteExpense(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Mois (1-12) : ");
                    tracker.afficherBilanMensuel(2026, sc.nextInt());
                    break;
                case 6:
                    quitter = true;
                    break;
            }
        }
        sc.close();
    }
}