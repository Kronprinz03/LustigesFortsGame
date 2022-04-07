package ym.lustigesFortsGame;

import lombok.Getter;
import lombok.Setter;
import ym.lustigesFortsGame.Objekt.Button.InitButtons;
@Getter
@Setter

public class Controll {
private GUI gui;
private InitButtons initButtons;

    //Erstell alles beim Starten der Anwendung
    public void creatGame(){
        initButtons = new InitButtons();
        gui = new GUI(1280,768, this);

            Thread GUI = new Thread (gui);
            GUI.start();
    }

    public void startSetup(){

    }

    //Ausführen bei Start
    private void startGame(){

    }

}
