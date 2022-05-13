package ym.lustigesFortsGame.map.plants;

import lombok.SneakyThrows;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Player;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;

public class Ananas extends Plant{

    public Ananas (int x, int y, Controll controll){
        this.grow0 = Images.getAnanas0();
        this.grow1 = Images.getAnanas1();
        this.grow2 = Images.getAnanas2();
        this.grow3 = Images.getAnanas3();
        grow = new Image[]{grow0, grow1,grow2,grow3};
        this.controll = controll;

        this.xFeld = x;
        this.yFeld = y;
        this.growingSpeed = 1000;
        this.grown = 0;
        growing();
    }


    @Override
    public Graphics draw(Graphics dbg) {
        dbg.drawImage(grow[grown],xFeld*40,yFeld*40,null);
        return dbg;
    }

    @Override
    public void harvest(Player spieler) {
        spieler.setAnanas(spieler.getAnanas()+1);
        grown = 2;
        growing();

    }
    @Override
    public void growing(){
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (grown < 3) {
                    finish = false;
                    Thread.sleep(growingSpeed);
                    grown++;
                }
                finish = true;
                System.out.println();
            }
        }).start();
    }
}
