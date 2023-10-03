package org.example;

import java.util.Objects;

public class SimplePerfectMazeGenerator extends Maze implements MazeGenerator {

    SimplePerfectMazeGenerator(int inputWidth, int inputHeight) {
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
            int randomIndex = getRandomNum(num);
            String[] randomTile = maze[randomIndex];

            int randomDirection = getRandomNum(4);

            String[] otherTile;

            switch (randomDirection) {
                case 0 -> {         // NORTH

                    try {                                               // Vérifie si la case cherchée existe
                        otherTile = maze[randomIndex - width];
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if (!Objects.equals(otherTile[4], randomTile[4])) {        // Si les num sont différents

                        randomTile[1] = ".";                    // Remplace les murs par des points
                        otherTile[7] = ".";
                    } else {
                        break;
                    }

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                case 1 -> {         // EAST

                    try {
                        otherTile = maze[randomIndex + 1];
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if ((randomIndex + 1) % width == 0) {               // Si le prochain tile est sur la prochaine ligne, recommencer
                        break;
                    }

                    if (!Objects.equals(otherTile[4], randomTile[4])) {        // Si les num sont différents

                        randomTile[5] = ".";                    // Remplace les murs par des points
                        otherTile[3] = ".";
                    } else {
                        break;
                    }

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                case 2 -> {         // SOUTH

                    try {
                        otherTile = maze[randomIndex + width];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if (!Objects.equals(otherTile[4], randomTile[4])) {        // Si les num sont différents
                        randomTile[7] = ".";
                        otherTile[1] = ".";
                    } else {
                        break;
                    }

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                case 3 -> {         // WEST

                    try {
                        otherTile = maze[randomIndex - 1];
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

                    finished = changeNums(otherTile, randomTile);          // Change le plus petit num par le plus grand et check si le maze est finis
                }
                default -> throw new IllegalStateException("Unexpected value: " + randomDirection);
            }

            if (finished) {
                for (String[] oneTile : maze) {
                    oneTile[4] = ".";
                    maze[0][1] = ".";
                    maze[num - 1][7] = ".";
                }
            }
        }
    }
}
