package org.example;

import java.util.Objects;

public class Maze {
    public static void getMaze(int largeur, int hauteur, String type, String methode) {

        if (Objects.equals(type, "imperfect") && Objects.equals(methode, "simple")) {
            SimpleImperfectMazeGenerator simpleImperfect = new SimpleImperfectMazeGenerator(largeur, hauteur);
            simpleImperfect.getMaze();
//        } else if (Objects.equals(type, "perfect") && Objects.equals(methode, "simple")) {
//            Maze.getSimpleImperfect(largeur, hauteur);
//        } else if (Objects.equals(type, "imperfect") && Objects.equals(methode, "graph")) {
//            Maze.getSimpleImperfect(largeur, hauteur);
//        } else if (Objects.equals(type, "perfect") && Objects.equals(methode, "graph")) {
//            Maze.getSimpleImperfect(largeur, hauteur);
//        } else if (Objects.equals(type, "imperfect") && Objects.equals(methode, "optimized")) {
//            Maze.getSimpleImperfect(largeur, hauteur);
//        } else if (Objects.equals(type, "perfect") && Objects.equals(methode, "optimized")) {
//            Maze.getSimpleImperfect(largeur, hauteur);
        } else {
            System.out.println("Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.");
        }


    }
}
