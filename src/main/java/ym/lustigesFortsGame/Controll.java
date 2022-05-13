package ym.lustigesFortsGame;

import lombok.Getter;
import lombok.Setter;
import ym.lustigesFortsGame.Clocks.AnimationClock;
import ym.lustigesFortsGame.Clocks.MoveClock;
import ym.lustigesFortsGame.Objekt.Button.ButtonTemplate;
import ym.lustigesFortsGame.Objekt.Button.InitButtons;
import ym.lustigesFortsGame.Objekt.Inventar.Inventar;
import ym.lustigesFortsGame.Objekt.Player;
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

//Clocks
private MoveClock moveClock;
private AnimationClock animationClock;

//Variblen
private int sizeX = 1240;
private int sizeY = 720;

private boolean pause = false;

    //Erstell alles beim Starten der Anwendung
    public void creatGame(){        creatObjects();
        gui = new GUI(sizeX,sizeY, this);

        Thread GUI = new Thread (gui);
        GUI.start();
    }

    //init der Objekte
    private void creatObjects(){

        initButtons = new InitButtons(sizeX,sizeY,this);
        spieler1 = new Player(sizeX/2-25/2,sizeY/2+25/2,20,40,this);
        map = new Map(this);
        moveClock = new MoveClock(spieler1);
        animationClock = new AnimationClock(this);
        inventar = new Inventar(sizeX-160,sizeY-200,120,160,this);

    }

    //Start Einstellungen
    public void startGame(){
        for (ButtonTemplate button : getInitButtons().getStartbuttons()){
            button.setAktive(false);
        }
        getGui().setIngame(true);
        moveClock.start();
        animationClock.start();
        System.out.println("lets GO");
    }

}
