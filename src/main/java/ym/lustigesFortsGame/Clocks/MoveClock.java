package ym.lustigesFortsGame.Clocks;

import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Player;
import ym.lustigesFortsGame.enums.Movment;

public class MoveClock extends Thread {
private Player spieler1;

    public MoveClock(Player spieler1){
        this.spieler1 = spieler1;
    }


    @Override
    public void run() {
        while (true){
            //-------------Movement Spieler-----------------
            if(spieler1.getMovment() == Movment.nachlinks){
                spieler1.setPosX(spieler1.getPosX()-5);
            }
            if(spieler1.getMovment() == Movment.nachrechts){
                spieler1.setPosX(spieler1.getPosX()+5);
            }
            if(spieler1.getMovment() == Movment.nachoben){
                spieler1.setPosY(spieler1.getPosY()-5);
            }
            if(spieler1.getMovment() == Movment.nachunten){
                spieler1.setPosY(spieler1.getPosY()+5);
            }

            try {
                sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
