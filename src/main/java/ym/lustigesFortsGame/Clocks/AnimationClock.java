package ym.lustigesFortsGame.Clocks;

import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Player;
import ym.lustigesFortsGame.enums.Direaction;
import ym.lustigesFortsGame.enums.Movment;
import ym.lustigesFortsGame.utils.Images;

public class AnimationClock extends Thread{

    private Controll controll;
    private Player spieler1;


    public AnimationClock (Controll controll){
        this.controll = controll;
        spieler1 = controll.getSpieler1();
    }

    @Override
    public void run() {

            int count = 0;
            while (true) {
                if (controll.isIngame()&&!(controll.isPause())) {
                    if (!spieler1.isHarvesting()) {
                        if (spieler1.getMovment() == Movment.nachlinks) {
                            if (count == 0) {
                                spieler1.setLaufImage(Images.getLinks2());
                            } else {
                                spieler1.setLaufImage(Images.getLinks3());
                            }
                        } else if (spieler1.getMovment() == Movment.nachoben) {
                            if (count == 0) {
                                spieler1.setLaufImage(Images.getOben2());
                            } else {
                                spieler1.setLaufImage(Images.getOben3());
                            }
                        } else if (spieler1.getMovment() == Movment.nachunten) {
                            if (count == 0) {
                                spieler1.setLaufImage(Images.getUnten2());
                            } else {
                                spieler1.setLaufImage(Images.getUnten3());
                            }
                        } else if (spieler1.getMovment() == Movment.nachrechts) {
                            if (count == 0) {
                                spieler1.setLaufImage(Images.getRechts2());
                            } else {
                                spieler1.setLaufImage(Images.getRechts3());
                            }
                        }
                        count++;
                        if (count > 1 || spieler1.getMovment() == Movment.stop) {
                            count = 0;
                        }
                        try {
                            sleep(300);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        spieler1.setMovment(Movment.stop);
                    }
                }else {
                    System.out.println();
                }

            }
    }
}
