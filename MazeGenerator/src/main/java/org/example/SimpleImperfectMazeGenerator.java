package org.example;

public class SimpleImperfectMazeGenerator extends BaseGenerator implements MazeGenerator {

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

    public void breakThings() {

        // Faire un tab des num de 0 à num-1 et enlever le num qui est remplacé à chaque fois

        // Get random tile

        double randomDouble = Math.random();
        int randomIndex = (int) (randomDouble * num);
        String[] randomTile = tilesTab[randomIndex];
        System.out.println(randomIndex);

        // Get random direction

        double randomDoubleAgain = Math.random();
        int randomNumber = (int) (randomDoubleAgain * 4);
        String[] tileLink;
        System.out.println(randomNumber);

        switch (randomNumber) {
            case 0:
                // north
                // si randomTile est la dernière ou la première de la ligne, break
                // check si la tile tileLink a le même num que randomTile et changer le num de tileLink quand on a cassé le mur
                System.out.println("ok0");
                try {
                    tileLink = tilesTab[randomIndex - width];
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }

                randomTile[1] = ".";
                tileLink[7] = ".";
                break;

            case 1:
                // east
                System.out.println("ok1");
                try {
                    tileLink = tilesTab[randomIndex + 1];
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }

                randomTile[5] = ".";
                tileLink[3] = ".";
                break;

            case 2:
                // south
                System.out.println("ok2");
                try {
                    tileLink = tilesTab[randomIndex + width];
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }

                randomTile[7] = ".";
                tileLink[1] = ".";
                break;

            case 3:
                // west
                System.out.println("ok3");
                try {
                    tileLink = tilesTab[randomIndex - 1];
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }

                randomTile[3] = ".";
                tileLink[5] = ".";
                break;
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
