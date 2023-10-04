package org.example;

import java.util.Objects;

public class GraphBasedImperfectMazeGenerator extends GraphBasedPerfectMazeGenerator implements MazeGenerator{
    GraphBasedImperfectMazeGenerator(int inputWidth, int inputHeight) {
        super(inputWidth, inputHeight);
    }

    public void getMaze() {
        getBaseTiles();
        breakMoreThings();
        displayMaze(maze);
    }

    public void breakMoreThings() {
        breakThings();

        int loops = 0;

        while (!Objects.equals(loops, height >> 2)) {

            int randomX = getRandomNum(width);
            int randomY = getRandomNum(height);

            GraphTiles tile = maze[randomY][randomX];
            GraphTiles otherTile;
            int direction = getRandomNum(4);


            switch (direction) {
                case 0 -> {         // NORTH

                    try {                                               // Vérifie si la case cherchée existe
                        otherTile = maze[randomY - 1][randomX];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if (Objects.equals(tile.northWall, "#")) {
                        tile.breakWall("north");                    // Remplace les murs par des points
                        otherTile.breakWall("south");

                        loops++;
                    }
                }
                case 1 -> {         // EAST

                    try {
                        otherTile = maze[randomY][randomX + 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if ((randomX + 1) % width != 0 && Objects.equals(tile.eastWall, "#")) {               // Si le prochain tile est sur la prochaine ligne, recommencer

                        tile.breakWall("east");                    // Remplace les murs par des points
                        otherTile.breakWall("west");

                        loops++;
                    }
                }
                case 2 -> {         // SOUTH

                    try {
                        otherTile = maze[randomY + 1][randomX];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if (Objects.equals(tile.southWall, "#")) {
                        tile.breakWall("south");
                        otherTile.breakWall("north");

                        loops++;
                    }
                }
                case 3 -> {         // WEST

                    try {
                        otherTile = maze[randomY][randomX - 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                    if ((randomX) % width != 0 && Objects.equals(tile.westWall, "#")) {
                        tile.breakWall("west");
                        otherTile.breakWall("east");

                        loops++;
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + direction);
            }
        }
    }
}
