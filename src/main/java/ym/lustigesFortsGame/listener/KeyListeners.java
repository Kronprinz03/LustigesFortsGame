package ym.lustigesFortsGame.listener;

import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Player;
import ym.lustigesFortsGame.enums.Direaction;
import ym.lustigesFortsGame.enums.Movment;
import ym.lustigesFortsGame.utils.Images;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyListeners implements KeyListener {

    private Controll controll;
    private boolean imageLoaded = false;

    public KeyListeners(Controll controll) {
        this.controll = controll;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (controll.getGui().isIngame()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ESCAPE:
                    controll.getDiePause().aufrufPause();
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

                case KeyEvent.VK_E:
                    if (controll.getInventar().isAktive()) {
                        controll.getInventar().setAktive(false);
                    } else {
                        controll.getInventar().setAktive(true);
                    }
                    break;
                case KeyEvent.VK_F:
                    if (!controll.getSpieler1().isHarvesting()) {
                        controll.getSpieler1().theHarvest();
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    controll.getSpieler1().plant();
                    break;
                case KeyEvent.VK_1:
                    controll.getSpieler1().setTool(1);
                    break;

                case KeyEvent.VK_2:
                    controll.getSpieler1().setTool(2);
                    break;
                case KeyEvent.VK_K:
                    Player spieler = controll.getSpieler1();
                    if (spieler.getSeedOpt() < 2) {
                        spieler.setSeedOpt(spieler.getSeedOpt() + 1);
                    } else {
                        spieler.setSeedOpt(0);
                    }
                    break;
                case KeyEvent.VK_P:
                    controll.getShop().aufrufShop();
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (controll.isIngame()) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    controll.getSpieler1().setMovment(Movment.stop);
                    imageLoaded = false;
            }
        }

    }

    // taste :  1 = D / 2 = S / 3 = A
    public Direaction switchDireaction(int taste) {

            Direaction direaction = controll.getSpieler1().getDireaction();
            Direaction nextDireaction = null;

        if (controll.isIngame()) {
            if (direaction == Direaction.oben) {
                switch (taste) {
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
            } else if (direaction == Direaction.unten) {
                switch (taste) {
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
            } else if (direaction == Direaction.rechts) {
                switch (taste) {
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
            } else {
                switch (taste) {
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

        }
        return nextDireaction;
    }



    public void setMovmentSpieler() {

        if (!controll.getSpieler1().isHarvesting()) {


            Direaction spielerDirreaction = controll.getSpieler1().getDireaction();
            Player spieler1 = controll.getSpieler1();

            if (spielerDirreaction == Direaction.rechts) {
                if (!imageLoaded) {
                    controll.getSpieler1().setLaufImage(Images.getRechts2());
                    imageLoaded = true;
                }
                spieler1.setMovment(Movment.nachrechts);
            } else if (spielerDirreaction == Direaction.links) {
                if (!imageLoaded) {
                    controll.getSpieler1().setLaufImage(Images.getLinks2());
                    imageLoaded = true;
                }
                spieler1.setMovment(Movment.nachlinks);
            } else if (spielerDirreaction == Direaction.oben) {
                if (!imageLoaded) {
                    controll.getSpieler1().setLaufImage(Images.getOben2());
                    imageLoaded = true;
                }
                spieler1.setMovment(Movment.nachoben);
            } else {
                if (!imageLoaded) {
                    controll.getSpieler1().setLaufImage(Images.getUnten2());
                    imageLoaded = true;
                }
                spieler1.setMovment(Movment.nachunten);
            }
        }
    }
}
