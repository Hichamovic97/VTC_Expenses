package org.example;


import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker {
    private List<Expenses> liste = new ArrayList<>();

    //methods:
    //Method add:
    public void addExpenses(Expenses expenses){
        liste.add(expenses);
    }
    //Method delete:
    public void deleteExpenses(int index){
        if (index >=0 && index < liste.size())
        liste.remove(index);
    }
    //Affichage:
    public void afficherTout() {
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(i + " - " + liste.get(i));
        }
    }
}
