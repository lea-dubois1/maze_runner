package org.example;

import java.util.ArrayList;

public class BaseGenerator {

    protected int largeur;
    protected int hauteur;

    public void getBaseTiles() {
        int num = this.hauteur * this.largeur;

        ArrayList<ArrayList<String>> tilesList = new ArrayList<ArrayList<String>>(num);

        ArrayList<String> tile = new ArrayList<String>(9);
        tile.add("#"); tile.add("#"); tile.add("#");
        tile.add("#"); tile.add("."); tile.add("#");
        tile.add("#"); tile.add("#"); tile.add("#");

        for (int i = 0; i < num; i++) {
            tilesList.add(tile);
        }
        
        int i = 0, j = 0;
        
        while (j != )
            while (i != 3) {
                System.out.print(tilesList.get(0).get(i));
                i++;
            }
            i = 0;

//        int l = 0;
//
////        for (int i = 1; i <= this.hauteur; i++) {               // Créer les lignes
//            for (int j = 0; j < this.largeur; j++) {            // Créer les colonnes pour chaque ligne
//                for (int m = 0; m < num; m++) {
//                    if(l >= 9) {
//                        l = 0;
//                    }
//                    for (int k = l; k < l+3; k++) {
//                        System.out.print(tilesList.get(m).get(k));
////                        System.out.println("m : " + m + ", k : " + k + ", l : " + l + ", j : " + j);
//                    }
////                    System.out.println("l tour " + i + " = " + l);
//                }
//                l += 3;
//
//                    System.out.println();
//            }

//            System.out.println();
//        }

//        for (int i = 0; i < tilesList.size(); i++) {                // Pour chaque tile
//            for (int j = 0; j < tilesList.get(i).size(); j++) {     // j = elem de la tile
//                System.out.print(tilesList.get(i).get(j) + " ");
//                if ((j+1)%3 == 0) {
//                    System.out.println();
//                }
//            }
//            System.out.println();
//        }
    }
}
