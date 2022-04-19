package ym.lustigesFortsGame.map.plants;

import lombok.Getter;
import lombok.SneakyThrows;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Player;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;
@Getter
public abstract class Plant {

    protected int xFeld;
    protected int yFeld;

    protected int min = 1;
    protected int max = 3;

    protected int grown = 0;
    protected Image[] grow;
    protected int growingSpeed;

    protected Image grow0;
    protected Image grow1;
    protected Image grow2;
    protected Image grow3;


    protected boolean finish;
    protected Controll controll;

    public abstract Graphics draw (Graphics dbg);

    public void growing(){
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                grown = 0;
                while (grown < 2) {
                    Thread.sleep(growingSpeed);
                    grown++;
                }
                finish = true;
            }
        }).start();
    }

    public abstract void harvest(Player spieler);

}
