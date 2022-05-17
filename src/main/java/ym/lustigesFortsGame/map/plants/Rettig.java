package ym.lustigesFortsGame.map.plants;

import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Player;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;
import java.util.Random;

public class Rettig extends Plant{

    public Rettig (int x, int y, Controll controll){
        this.grow0 = Images.getRettig0();
        this.grow1 = Images.getRettig1();
        this.grow2 = Images.getRettig2();
        grow = new Image[]{grow0, grow1,grow2};
        this.controll = controll;

        this.xFeld = x;
        this.yFeld = y;
        this.growingSpeed = 4000;
        growing();
    }



    @Override
    public Graphics draw(Graphics dbg) {
        dbg.drawImage(grow[grown],xFeld*40,yFeld*40,null);
        return dbg;
    }


    @Override
    public void  harvest(Player spieler) {
        int seed = 0;

        Random random = new Random();
        int value = random.nextInt(1 + 10) + 1;

        if(value > 5){
            seed = 1;
        }
        if(value > 9){
            seed = 2;
        }


        spieler.setRettig(spieler.getRettig()+1);
        spieler.setIngRettig(spieler.getIngRettig()+1);
        spieler.setRettigSamen(spieler.getRettigSamen()+seed);
        controll.getMap().getPlants().remove(this);

    }


}
