package ym.lustigesFortsGame.Objekt;

import java.awt.*;

public class Player {
    //Positionen
    private int posX;
    private int posY;

    private int width;
    private int height;






    public Player(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public Graphics draw (Graphics dbg){
        dbg.fillRect(posX, posY, width, height);

        return dbg;
    }
}
