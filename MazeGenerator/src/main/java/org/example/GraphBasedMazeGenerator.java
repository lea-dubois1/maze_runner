package org.example;

public class GraphBasedMazeGenerator extends Maze implements MazeGenerator {

    protected GraphTiles[][] maze;

    GraphBasedMazeGenerator(int inputWidth, int inputHeight) {
        super(inputWidth, inputHeight);
    }

    public void getMaze() {
        getBaseTiles();
        breakThings();
        displayMaze(maze);
    }

    public void breakThings() {

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
                ligne1.append("#").append(tile.southWall).append("#");
                ligne2.append(tile.westWall).append(tile.core).append(tile.eastWall);
                ligne3.append("#").append(tile.northWall).append("#");
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
