package org.example;

import java.util.ArrayList;

public class BaseGenerator {

    protected int largeur;
    protected int hauteur;

    public void getBaseTiles() {
        int num = hauteur * largeur;
        String[][] tilesTab = new String[num][9];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 4) {
                    tilesTab[i][j] = Integer.toString(i);
                } else {
                    tilesTab[i][j] = "#";
                }
            }
        }

        String ligne1 = "";
        String ligne2 = "";
        String ligne3 = "";

        for (int j = 0; j < tilesTab.length; j++) {
            for (int i = 0; i < tilesTab[j].length; i++) {
                if (i <= 2) {
                    ligne1 += tilesTab[j][i];
                } else if (i <= 5) {
                    ligne2 += tilesTab[j][i];
                } else if (i <= 8) {
                    ligne3 += tilesTab[j][i];
                }
            }
            if ((j+1) % largeur == 0) {
                System.out.println("ligne 1 : " + ligne1);
                System.out.println("ligne 2 : " + ligne2);
                System.out.println("ligne 3 : " + ligne3);
                ligne1 = "";
                ligne2 = "";
                ligne3 = "";
            }
        }
    }
}
