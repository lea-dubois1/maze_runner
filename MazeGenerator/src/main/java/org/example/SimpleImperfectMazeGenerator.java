package org.example;

import java.util.Objects;

public class SimpleImperfectMazeGenerator extends SimplePerfectMazeGenerator implements MazeGenerator{
    SimpleImperfectMazeGenerator(int inputWidth, int inputHeight) {
        super(inputWidth, inputHeight);
    }

    public void getMaze() {
        getBaseTiles();
        breakMoreThings();
        System.out.println();
        System.out.println();
        displayMaze(maze);
    }

    public void breakMoreThings() {
        breakThings();

        displayMaze(maze);

        int loops = 0;

        while (!Objects.equals(loops, height >> 2)) {

            int randomIndex = getRandomNum(num);
            String[] tile = maze[randomIndex];
            String[] otherTile;
            int direction = getRandomNum(4);


            switch (direction) {
                case 0 -> {         // NORTH

                    try {                                               // Vérifie si la case cherchée existe
                        otherTile = maze[randomIndex - width];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if (Objects.equals(tile[1], "#")) {
                        tile[1] = ".";                    // Remplace les murs par des points
                        otherTile[7] = ".";

                        loops++;
                    }
                }
                case 1 -> {         // EAST

                    try {
                        otherTile = maze[randomIndex + 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if ((randomIndex + 1) % width != 0 && Objects.equals(tile[5], "#")) {               // Si le prochain tile est sur la prochaine ligne, recommencer

                        tile[5] = ".";                    // Remplace les murs par des points
                        otherTile[3] = ".";

                        loops++;
                    }
                }
                case 2 -> {         // SOUTH

                    try {
                        otherTile = maze[randomIndex + width];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if (Objects.equals(tile[7], "#")) {
                        tile[7] = ".";
                        otherTile[1] = ".";

                        loops++;
                    }
                }
                case 3 -> {         // WEST

                    try {
                        otherTile = maze[randomIndex - 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if ((randomIndex) % width != 0 && Objects.equals(tile[3], "#")) {
                        tile[3] = ".";
                        otherTile[5] = ".";

                        loops++;
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + direction);
            }
        }
    }
}
