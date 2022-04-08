package ym.lustigesFortsGame.listener;

import ym.lustigesFortsGame.Controll;

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
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
