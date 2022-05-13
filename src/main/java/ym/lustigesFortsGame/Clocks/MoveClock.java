package ym.lustigesFortsGame.Clocks;

import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Player;
import ym.lustigesFortsGame.enums.Movment;

public class MoveClock extends Thread {
private Player spieler1;
private int speed = 5;

    public MoveClock(Player spieler1){
        this.spieler1 = spieler1;
    }


    @Override
    public void run() {
        while (true){
            //-------------Movement Spieler-----------------
            if(!spieler1.isHarvesting()) {
                if(isMoveOkay()) {
                    if (spieler1.getMovment() == Movment.nachlinks) {
                        spieler1.setPosX(spieler1.getPosX() - speed);
                    }
                    if (spieler1.getMovment() == Movment.nachrechts) {
                        spieler1.setPosX(spieler1.getPosX() + speed);
                    }
                    if (spieler1.getMovment() == Movment.nachoben) {
                        spieler1.setPosY(spieler1.getPosY() - speed);
                    }
                    if (spieler1.getMovment() == Movment.nachunten) {
                        spieler1.setPosY(spieler1.getPosY() + speed);
                    }
                    spieler1.loadharvest();
                }

                try {
                    sleep(1000 / 60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    private boolean isMoveOkay(){
        return spieler1.isMoveOkay();
    }
}
