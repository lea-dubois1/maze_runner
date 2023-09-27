package org.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int largeur = 0;
        int hauteur = 0;
        String type = args[2];
        String methode = args[3];

        try {
            largeur = Integer.parseInt(args[0]);
            hauteur = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException e) {
            System.out.println("Erreur inattendue lors de la génération du labyrinthe. Veuillez réessayer.");
        }

        if (largeur >= 5 && hauteur >= 5 && !Objects.equals(args[2], "") && !args[2].isEmpty() && !Objects.equals(args[3], "") && !args[3].isEmpty() && Objects.equals(type, "imperfect") || Objects.equals(type, "perfect") && Objects.equals(methode, "simple") || Objects.equals(methode, "graph") || Objects.equals(methode, "optimized")) {

            Maze.getMaze(largeur, hauteur, type, methode);

        } else if (largeur < 5 || hauteur < 5) {
            System.out.println("Erreur : Veuillez fournir une largeur et une hauteur valides supérieurs à 5");
        } else if (Objects.equals(args[2], "") || args[2].isEmpty() || Objects.equals(args[3], "") || args[3].isEmpty()) {
            System.out.println("Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.");
        } else if (!Objects.equals(type, "imperfect") && !Objects.equals(type, "perfect") || !Objects.equals(methode, "simple") && !Objects.equals(methode, "graph") && !Objects.equals(methode, "optimized")) {
            System.out.println("Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.");
        }
    }
}