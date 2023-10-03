package org.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int largeur = 0;
        int hauteur = 0;
        String type = args[2];
        String methode = args[3];

        String error = "";

        try {
            largeur = Integer.parseInt(args[0]);
            hauteur = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException e) {
            error = "Erreur : Veuillez fournir une largeur et une hauteur valides supérieurs à 5";
        }
        catch (Exception ex) {
            error = "Erreur inattendue lors de la génération du labyrinthe. Veuillez réessayer.";
        }


        if (largeur >= 5 && hauteur >= 5 && !Objects.equals(args[2], "") && !args[2].isEmpty() && !Objects.equals(args[3], "") && !args[3].isEmpty() && Objects.equals(type, "imperfect") || Objects.equals(type, "perfect") && Objects.equals(methode, "simple") || Objects.equals(methode, "graph") || Objects.equals(methode, "optimized")) {

            if (Objects.equals(type, "imperfect") && Objects.equals(methode, "simple")) {
                SimpleImperfectMazeGenerator simpleImperfect = new SimpleImperfectMazeGenerator(largeur, hauteur);
                simpleImperfect.getMaze();

            } else if (Objects.equals(type, "perfect") && Objects.equals(methode, "simple")) {
                SimplePerfectMazeGenerator simplePerfect = new SimplePerfectMazeGenerator(largeur, hauteur);
                simplePerfect.getMaze();

            } else if (Objects.equals(type, "imperfect") && Objects.equals(methode, "graph")) {
                GraphBasedMazeGenerator graph = new GraphBasedMazeGenerator(largeur, hauteur);
                graph.getMaze();

            } else if (Objects.equals(type, "perfect") && Objects.equals(methode, "graph")) {
//                Maze.getSimpleImperfect(largeur, hauteur);
                error = "Erreur : Cette fonctionnalité n'est pas encore implémentée";

            } else if (Objects.equals(type, "imperfect") && Objects.equals(methode, "optimized")) {
//                Maze.getSimpleImperfect(largeur, hauteur);
                error = "Erreur : Cette fonctionnalité n'est pas encore implémentée";

            } else if (Objects.equals(type, "perfect") && Objects.equals(methode, "optimized")) {
//                Maze.getSimpleImperfect(largeur, hauteur);
                error = "Erreur : Cette fonctionnalité n'est pas encore implémentée";

            } else {
                error = "Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.";
            }

        } else if (largeur < 5 || hauteur < 5) {
            error = "Erreur : Veuillez fournir une largeur et une hauteur valides supérieurs à 5";
        } else if (Objects.equals(args[2], "") || args[2].isEmpty() || Objects.equals(args[3], "") || args[3].isEmpty()) {
            error = "Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.";
        } else if (!Objects.equals(type, "imperfect") && !Objects.equals(type, "perfect") || !Objects.equals(methode, "simple") && !Objects.equals(methode, "graph") && !Objects.equals(methode, "optimized")) {
            error = "Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.";
        } else {
            error = "Erreur inattendue lors de la génération du labyrinthe. Veuillez réessayer.";
        }

        if (!Objects.equals(error, "")) {
            System.out.println(error);
            System.out.println("Utilisation : java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]");
        }
    }
}