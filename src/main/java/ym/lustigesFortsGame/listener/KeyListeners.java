package ym.lustigesFortsGame.listener;

import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Player;
import ym.lustigesFortsGame.enums.Direaction;
import ym.lustigesFortsGame.enums.Movment;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyListeners implements KeyListener {

    private Controll controll;

    public KeyListeners(Controll controll){
         this.controll = controll;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                if(controll.isPause()){
                    controll.setPause(false);
                }else{
                    controll.setPause(true);
                }
                break;
            case KeyEvent.VK_W:
               setMovmentSpieler();

                break;
            case KeyEvent.VK_A:
                controll.getSpieler1().setDireaction(switchDireaction(1));
                controll.getSpieler1().setMovment(Movment.stop);
                break;
            case KeyEvent.VK_S:
                controll.getSpieler1().setDireaction(switchDireaction(2));
                controll.getSpieler1().setMovment(Movment.stop);
                break;
            case KeyEvent.VK_D:
                controll.getSpieler1().setDireaction(switchDireaction(3));
                controll.getSpieler1().setMovment(Movment.stop);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                controll.getSpieler1().setMovment(Movment.stop);
        }


    }

    // taste :  1 = D / 2 = S / 3 = A
    public Direaction switchDireaction(int taste){

        Direaction direaction = controll.getSpieler1().getDireaction();
        Direaction nextDireaction = null;

        if(direaction == Direaction.oben){
            switch (taste){
                case 1:
                    nextDireaction = Direaction.rechts;
                    break;
                case 2:
                    nextDireaction = Direaction.unten;
                    break;
                case 3:
                    nextDireaction = Direaction.links;
                    break;
            }
        }else if (direaction == Direaction.unten){
            switch (taste){
                case 1:
                    nextDireaction = Direaction.links;
                    break;
                case 2:
                    nextDireaction = Direaction.oben;
                    break;
                case 3:
                    nextDireaction = Direaction.rechts;
                    break;
            }
        }else if(direaction == Direaction.rechts){
            switch (taste){
                case 1:
                    nextDireaction = Direaction.unten;
                    break;
                case 2:
                    nextDireaction = Direaction.links;
                    break;
                case 3:
                    nextDireaction = Direaction.oben;
                    break;
            }
        }else {
            switch (taste){
                case 1:
                    nextDireaction = Direaction.oben;
                    break;
                case 2:
                    nextDireaction = Direaction.rechts;
                    break;
                case 3:
                    nextDireaction = Direaction.unten;
                    break;
            }
        }
        return nextDireaction;
    }

    public void setMovmentSpieler(){
        Direaction spielerDirreaction = controll.getSpieler1().getDireaction();
        Player spieler1 = controll.getSpieler1();

        if(spielerDirreaction == Direaction.rechts){
            spieler1.setMovment(Movment.nachrechts);
        }else if(spielerDirreaction == Direaction.links){
            spieler1.setMovment(Movment.nachlinks);
        }else  if(spielerDirreaction == Direaction.oben){
            spieler1.setMovment(Movment.nachoben);
        }else {
            spieler1.setMovment(Movment.nachunten);
        }
    }

}
