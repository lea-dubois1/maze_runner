package org.example;

import java.util.Objects;

public class Maze {
    protected final int width;
    protected final int num;
    protected final int height;
    protected String[][] tilesTab;

    Maze(int inputWidth, int inputHeight) {
        width = inputWidth;
        height = inputHeight;
        num = height * width;
    }

    public void getBaseTiles() {

        tilesTab = new String[num][9];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 4) {
                    tilesTab[i][j] = Integer.toString(i);
                } else {
                    tilesTab[i][j] = "#";
                }
            }
        }
    }

    public int getRandomNum(int limit) {
        double randomDouble = Math.random();
        return (int) (randomDouble * limit);
    }

    public boolean changeNums(String[] otherTile, String[] randomTile) {

        String changedNum, newNum;

        if (Integer.parseInt(otherTile[4]) > Integer.parseInt(randomTile[4])) {         // Vérifier lequel est le plus petit et lequel est le plus grand
            changedNum = otherTile[4];
            newNum = randomTile[4];
        } else {
            changedNum = randomTile[4];
            newNum = otherTile[4];
        }

        int numOfZeros = 0;

        for (String[] oneTile : tilesTab) {
            if (Objects.equals(oneTile[4], changedNum)) {         // Changer toutes les cases qui ont le plus grand nombre par le plus petit
                oneTile[4] = newNum;
            }
            if (Objects.equals(oneTile[4], "0")) {                // Compter les tuiles avec un zero
                numOfZeros++;
            }
        }

        return numOfZeros == num;               // Si toutes les tuiles sont en 0, le labyrinthe est terminé
    }

    public void displayMaze(String[][] tab) {

        StringBuilder ligne1 = new StringBuilder();
        StringBuilder ligne2 = new StringBuilder();
        StringBuilder ligne3 = new StringBuilder();

        for (int j = 0; j < tab.length; j++) {
            for (int i = 0; i < tab[j].length; i++) {
                if (i <= 2) {
                    ligne1.append(tab[j][i]);
                } else if (i <= 5) {
                    ligne2.append(tab[j][i]);
                } else if (i <= 8) {
                    ligne3.append(tab[j][i]);
                }
            }
            if ((j+1) % width == 0) {
                System.out.println(ligne1);
                System.out.println(ligne2);
                System.out.println(ligne3);
                ligne1 = new StringBuilder();
                ligne2 = new StringBuilder();
                ligne3 = new StringBuilder();
            }
        }
    }
}
