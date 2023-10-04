package org.example;

import java.util.Objects;

public class GraphBasedPerfectMazeGenerator extends Maze implements MazeGenerator {

    protected GraphTiles[][] maze;

    GraphBasedPerfectMazeGenerator(int inputWidth, int inputHeight) {
        super(inputWidth, inputHeight);
    }

    public void getMaze() {
        getBaseTiles();
        breakThings();
        displayMaze(maze);
    }

    public void breakThings() {
        boolean finished = false;

        while (!finished) {
            int randomX = getRandomNum(width);
            int randomY = getRandomNum(height);
            GraphTiles randomTile = maze[randomY][randomX];

            int randomDirection = getRandomNum(4);

            GraphTiles otherTile;

            switch (randomDirection) {
                case 0 -> {         // NORTH

                    try {                                               // Vérifie si la case cherchée existe
                        otherTile = maze[randomY - 1][randomX];
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if (!Objects.equals(otherTile.core, randomTile.core)) {        // Si les num sont différents

                        randomTile.breakWall("north");                    // Remplace les murs par des points
                        otherTile.breakWall("south");
                    } else {
                        break;
                    }

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                case 1 -> {         // EAST

                    try {
                        otherTile = maze[randomY][randomX + 1];
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if ((randomX + 1) % width == 0) {               // Si le prochain tile est sur la prochaine ligne, recommencer
                        break;
                    }

                    if (!Objects.equals(otherTile.core, randomTile.core)) {        // Si les num sont différents

                        randomTile.breakWall("east");                    // Remplace les murs par des points
                        otherTile.breakWall("west");
                    } else {
                        break;
                    }

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                case 2 -> {         // SOUTH

                    try {
                        otherTile = maze[randomY + 1][randomX];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if (!Objects.equals(otherTile.core, randomTile.core)) {        // Si les num sont différents
                        randomTile.breakWall("south");
                        otherTile.breakWall("north");
                    } else {
                        break;
                    }

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                case 3 -> {         // WEST

                    try {
                        otherTile = maze[randomY][randomX - 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }
                    if ((randomX) % width == 0) {
                        break;
                    }

                    if (!Objects.equals(otherTile.core, randomTile.core)) {        // Si les num sont différents
                        randomTile.breakWall("west");
                        otherTile.breakWall("east");
                    } else {
                        break;
                    }

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                default -> throw new IllegalStateException("Unexpected value: " + randomDirection);
            }

            if (finished) {
                for (GraphTiles[] oneLine : maze) {
                    for (GraphTiles oneTile : oneLine) {
                        oneTile.changeCoreEnd();
                    }
                }
                maze[0][0].northWall = ".";
                maze[height - 1][width - 1].southWall = ".";
            }
        }
    }

    public boolean changeNums(GraphTiles otherTile, GraphTiles randomTile) {

        String changedNum, newNum;

        if (Integer.parseInt(otherTile.core) > Integer.parseInt(randomTile.core)) {         // Vérifier lequel est le plus petit et lequel est le plus grand
            changedNum = otherTile.core;
            newNum = randomTile.core;
        } else {
            changedNum = randomTile.core;
            newNum = otherTile.core;
        }

        int numOfZeros = 0;

        for (GraphTiles[] oneLine : maze) {
            for (GraphTiles oneTile : oneLine) {
                if (Objects.equals(oneTile.core, changedNum)) {         // Changer toutes les cases qui ont le plus grand nombre par le plus petit
                    oneTile.changeCoreNum(newNum);
                }
                if (Objects.equals(oneTile.core, "0")) {                // Compter les tuiles avec un zero
                    numOfZeros++;
                }
            }
        }

        return numOfZeros == num;               // Si toutes les tuiles sont en 0, le labyrinthe est terminé
    }

    public void getBaseTiles() {
        maze = new GraphTiles[height][width];

        int tileNum = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                GraphTiles tile = new GraphTiles(i, j, tileNum);
                maze[i][j] = tile;
                tileNum++;
            }
        }
    }

    public void displayMaze(GraphTiles[][] lab) {

        StringBuilder ligne1 = new StringBuilder();
        StringBuilder ligne2 = new StringBuilder();
        StringBuilder ligne3 = new StringBuilder();

        for (GraphTiles[] tiles : lab) {
            for (GraphTiles tile : tiles) {
                ligne1.append("#").append(tile.northWall).append("#");
                ligne2.append(tile.westWall).append(tile.core).append(tile.eastWall);
                ligne3.append("#").append(tile.southWall).append("#");
            }
            System.out.println(ligne1);
            System.out.println(ligne2);
            System.out.println(ligne3);
            ligne1 = new StringBuilder();
            ligne2 = new StringBuilder();
            ligne3 = new StringBuilder();
        }
    }
}
