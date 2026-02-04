package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        boolean quitter=false;
        int choix;
        Scanner sc = new Scanner(System.in);
        while(!quitter){
            System.out.println("\n--- MENU UBER EXPENSES ---");
            System.out.println("1. Ajouter une dépense");
            System.out.println("2. Supprimer une dépense");
            System.out.println("3. Calculer total annuel");
            System.out.println("4. Quitter");
            System.out.print("Choisie une Option : ");
choix = sc.nextInt();
switch (choix){
    case 1:

        System.out.print("Montant : ");
        double m = sc.nextDouble();
        sc.nextLine();
        System.out.print("Catégorie (Essence, Entretien...) : ");
        String c = sc.nextLine();
        // On utilise la date d'aujourd'hui par défaut pour simplifier
        tracker.ajouter(new Expenses(m, c, LocalDate.now()));
        break;
    case 2:
        tracker.afficherTout();
        System.out.print("Index à supprimer : ");
        tracker.supprimer(sc.nextInt());
        break;
    case 3:
        System.out.print("Année (ex: 2026) : ");
        int an = sc.nextInt();
        System.out.println("Total pour " + an + " : " + tracker.calculerTotalAnnee(an) + "$");
        break;
    case 4:
        quitter = true;
        break;
}
        }

    }
}