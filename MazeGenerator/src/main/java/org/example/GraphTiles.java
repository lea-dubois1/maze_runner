package org.example;

import java.util.Objects;

public class GraphTiles {
    public int X;
    public int Y;
    public String southWall = "#";
    public String westWall = "#";
    public String core;
    public String eastWall = "#";
    public String northWall = "#";

    GraphTiles(int axeY, int axeX, int tileNum) {
        this.X = axeX;
        this.Y = axeY;
        this.core = Integer.toString(tileNum);
    }

    public void breakWall(String direction) {
        switch (direction) {
            case "south" -> {
                if (!Objects.equals(this.southWall, ".")) this.southWall = ".";
            }

            case "east" -> {
                if (!Objects.equals(this.eastWall, ".")) this.eastWall = ".";
            }

            case "north" -> {
                if (!Objects.equals(this.northWall, ".")) this.northWall = ".";
            }

            case "west" -> {
                if (!Objects.equals(this.westWall, ".")) this.westWall = ".";
            }
        }
    }

    public void changeCoreEnd() {
        core = ".";
    }

    public void changeCoreNum(String numAfter) {
        core = numAfter;
    }
}
