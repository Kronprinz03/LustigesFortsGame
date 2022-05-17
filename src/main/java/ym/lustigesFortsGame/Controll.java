package ym.lustigesFortsGame;

import lombok.Getter;
import lombok.Setter;
import ym.lustigesFortsGame.Clocks.AnimationClock;
import ym.lustigesFortsGame.Clocks.EnergyClock;
import ym.lustigesFortsGame.Clocks.MoveClock;
import ym.lustigesFortsGame.Clocks.Playtime;
import ym.lustigesFortsGame.Objekt.Button.ButtonTemplate;
import ym.lustigesFortsGame.Objekt.Button.InitButtons;
import ym.lustigesFortsGame.Objekt.Inventar.Inventar;
import ym.lustigesFortsGame.Objekt.Pause;
import ym.lustigesFortsGame.Objekt.Player;
import ym.lustigesFortsGame.Objekt.Punktescreen;
import ym.lustigesFortsGame.Objekt.Shop;
import ym.lustigesFortsGame.map.Map;

import java.io.File;

@Getter
@Setter

public class Controll {

//Objekts
private GUI gui;
private InitButtons initButtons;
private Player spieler1;
private Map map;
private File collision = null;
private Inventar inventar;
private Shop shop;
private Punktescreen punktescreen;
private Pause diePause;



//Clocks
private MoveClock moveClock;
private AnimationClock animationClock;
private Playtime playtime;
private EnergyClock energyClock;

//Variblen
private int sizeX = 1240;
private int sizeY = 720;

private boolean pause = false;

private boolean ingame = false;
private boolean start = true;

    //Erstell alles beim Starten der Anwendung
    public void creatGame(){
        ingame = false;
        start = true;
        creatObjects();
        gui = new GUI(sizeX,sizeY, this);

        moveClock.start();
        animationClock.start();
        Thread GUI = new Thread (gui);
        GUI.start();

    }

    //init der Objekte
    private void creatObjects(){
        shop = new Shop(100, 100, sizeX-200,sizeY-200,this);
        initButtons = new InitButtons(sizeX,sizeY,this);
        spieler1 = new Player(sizeX/2-25/2,sizeY/2+25/2,20,40,this);
        map = new Map(this);

        moveClock = new MoveClock(spieler1,this);
        animationClock = new AnimationClock(this);
        inventar = new Inventar(sizeX-160,sizeY-200,120,160,this);






    }

    //Start Einstellungen
    public void startGame(){
        start = false;
        ingame = true;
        gui.setStart(false);
        for (ButtonTemplate button : getInitButtons().getStartbuttons()){
            button.setAktive(false);
        }

        playtime = new Playtime(200,this,0,1240);
        playtime.start();
        energyClock = new EnergyClock(this);
        energyClock.start();

        punktescreen = new Punktescreen(sizeX/2 - 250,50,500,sizeY-100,this);

        map.loadMap();
        map.loadOverlay();
        map.loadCollision();

        shop.setGeld(0);
        spieler1.setPosX(sizeX/2-25/2);
        spieler1.setPosY(sizeY/2+25/2);
        spieler1.setRettigSamen(1);
        spieler1.setGurkenSamen(0);
        spieler1.setAnanasSamen(0);
        spieler1.setEnergy(100);
        spieler1.setBaum(0);

        spieler1.setIngAnanas(0);
        spieler1.setIngGurke(0);
        spieler1.setIngRettig(0);
        spieler1.setIngBaum(0);

        diePause = new Pause(sizeX/2 - 250,50,500,sizeY-100,this);
        getGui().setIngame(true);


    }


    //Beende Spiel
    public void beendeSpiel(){
        ingame = false;
        start = true;
        playtime.stop();
        gui.setIngame(false);
        gui.setStart(true);

        pause = false;



        for (ButtonTemplate button : getInitButtons().getStartbuttons()){
            button.setAktive(true);
        }


    }

}
