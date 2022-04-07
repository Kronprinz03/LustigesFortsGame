package ym.lustigesFortsGame;

import ym.lustigesFortsGame.Objekt.Button.InitButtons;

public class Controll {
private GUI gui;
private InitButtons initButtons;


    public Controll(){
        creatGame();
    }


    //Erstell alles beim Starten der Anwendung
    private void creatGame(){
            gui = new GUI(1280,768);
            initButtons = new InitButtons();

            Thread GUI = new Thread (gui);
            GUI.start();

    }

    public void startSetup(){

    }

    //Ausführen bei Start
    private void startGame(){

    }

}
