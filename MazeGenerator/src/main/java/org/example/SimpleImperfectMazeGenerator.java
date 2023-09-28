package org.example;

import java.util.Arrays;
import java.util.Objects;

public class SimpleImperfectMazeGenerator implements MazeGenerator {

    private int width;
    private int height;
    private int num;
    private String[][] tilesTab;


    SimpleImperfectMazeGenerator(int lar, int hau) {
        width = lar;
        height = hau;
        num = height * width;
    }

    public void getMaze() {
        getBaseTiles();
        breakThings();
        displayMaze(tilesTab);
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

    public void breakThings() {

        boolean finished = false;

        while (!finished) {
            int randomIndex = getRandomNum(num);
            String[] randomTile = tilesTab[randomIndex];

            int randomDirection = getRandomNum(4);

            String[] otherTile;

            switch (randomDirection) {
                case 0 -> {         // NORTH

                    try {                                               // Vérifier si la case cherchée existe
                        otherTile = tilesTab[randomIndex - width];
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if (!Objects.equals(otherTile[4], randomTile[4])) {        // Si les num sont différents

                        randomTile[1] = ".";                    // Remplacer les murs par des points
                        otherTile[7] = ".";
                    } else {
                        break;
                    }

//                    System.out.println("ok0");
//                    System.out.println(Arrays.toString(otherTile));
//                    System.out.println(Arrays.toString(randomTile));

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                case 1 -> {         // EAST

                    try {
                        otherTile = tilesTab[randomIndex + 1];
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if ((randomIndex + 1) % width == 0) {               // Si le prochain tile est sur la prochaine ligne, recommencer
                        break;
                    }

                    if (!Objects.equals(otherTile[4], randomTile[4])) {        // Si les num sont différents

                        randomTile[5] = ".";                    // Remplacer les murs par des points
                        otherTile[3] = ".";
                    } else {
                        break;
                    }

//                    System.out.println("ok1");
//                    System.out.println(Arrays.toString(otherTile));
//                    System.out.println(Arrays.toString(randomTile));

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                case 2 -> {         // SOUTH

                    try {
                        otherTile = tilesTab[randomIndex + width];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if (!Objects.equals(otherTile[4], randomTile[4])) {        // Si les num sont différents
                        randomTile[7] = ".";
                        otherTile[1] = ".";
                    } else {
                        break;
                    }

//                    System.out.println("ok2");
//                    System.out.println(Arrays.toString(otherTile));
//                    System.out.println(Arrays.toString(randomTile));

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                case 3 -> {         // WEST

                    try {
                        otherTile = tilesTab[randomIndex - 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }
                    if ((randomIndex) % width == 0) {
                        break;
                    }

                    if (!Objects.equals(otherTile[4], randomTile[4])) {        // Si les num sont différents
                        randomTile[3] = ".";
                        otherTile[5] = ".";
                    } else {
                        break;
                    }

//                    System.out.println("ok3");
//                    System.out.println(Arrays.toString(otherTile));
//                    System.out.println(Arrays.toString(randomTile));

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                default -> throw new IllegalStateException("Unexpected value: " + randomDirection);
            }

            if (finished) {
                for (String[] oneTile : tilesTab) {
                    oneTile[4] = ".";
                    tilesTab[0][1] = ".";
                    tilesTab[num - 1][7] = ".";
                }
            }

        }
    }

    public void displayMaze(String[][] tab) {

        String ligne1 = "";
        String ligne2 = "";
        String ligne3 = "";

        for (int j = 0; j < tab.length; j++) {
            for (int i = 0; i < tab[j].length; i++) {
                if (i <= 2) {
                    ligne1 += tab[j][i];
                } else if (i <= 5) {
                    ligne2 += tab[j][i];
                } else if (i <= 8) {
                    ligne3 += tab[j][i];
                }
            }
            if ((j+1) % width == 0) {
                System.out.println(ligne1);
                System.out.println(ligne2);
                System.out.println(ligne3);
                ligne1 = "";
                ligne2 = "";
                ligne3 = "";
            }
        }
    }
}
