package ym.lustigesFortsGame.map.plants;

import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Player;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;
import java.util.Random;

public class Gurke extends Plant{




    public Gurke (int x, int y, Controll controll){
        this.grow0 = Images.getGurke0();
        this.grow1 = Images.getGurke1();
        this.grow2 = Images.getGurke2();
        grow = new Image[]{grow0, grow1,grow2};
        this.controll = controll;

        this.xFeld = x;
        this.yFeld = y;
        this.growingSpeed = 6000;
        growing();
    }

    @Override
    public Graphics draw(Graphics dbg) {
        dbg.drawImage(grow[grown],xFeld*40,yFeld*40,null);
        return dbg;
    }

    @Override
    public void harvest(Player spieler) {
        int seed = 0;

        Random random = new Random();
        int value = random.nextInt(1 + 10) + 1;

        if(value > 7){
            seed = 1;
        }
        if(value > 9){
            seed = 2;
        }
        spieler.setGurke(spieler.getGurke()+1);
        spieler.setIngGurke(spieler.getIngGurke()+1);
        spieler.setGurkenSamen(spieler.getGurkenSamen()+seed);
        controll.getMap().getPlants().remove(this);
    }
}
