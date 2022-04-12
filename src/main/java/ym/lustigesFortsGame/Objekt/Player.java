package ym.lustigesFortsGame.Objekt;

import lombok.Getter;
import lombok.Setter;
import ym.lustigesFortsGame.enums.Direaction;
import ym.lustigesFortsGame.enums.Movment;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;



@Getter
@Setter

public class Player {
    //Positionen
    private int posX;
    private int posY;

    private int width;
    private int height;

    //Enum
    private Direaction direaction = Direaction.unten;
    private Movment movment = Movment.stop;

    //Attribut
    private Image laufImage = null;


    public Player(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public Graphics draw (Graphics dbg){


        // wenn der Spieler steht
       if(getMovment() == Movment.stop) {
            if (getDireaction() == Direaction.oben) {
                dbg.drawImage(Images.getOben1(), getPosX(), getPosY(), null);
            }
            if (getDireaction() == Direaction.unten) {
                dbg.drawImage(Images.getUnten1(), getPosX(), getPosY(), null);
            }
            if (getDireaction() == Direaction.rechts) {
                dbg.drawImage(Images.getRechts1(), getPosX(), getPosY(), null);
            }
            if (getDireaction() == Direaction.links) {
                dbg.drawImage(Images.getLinks1(), getPosX(), getPosY(), null);
            }
       }else {
           dbg.drawImage(getLaufImage(),getPosX(),getPosY(),null);
       }
        return dbg;
    }
}
