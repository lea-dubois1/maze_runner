package org.example;

public class SimpleImperfectMazeGenerator extends BaseGenerator implements MazeGenerator {

    SimpleImperfectMazeGenerator(int lar, int hau) {
        this.largeur = lar;
        this.hauteur = hau;
    }

    public void getMaze() {
        this.getBaseTiles();
    }
}
