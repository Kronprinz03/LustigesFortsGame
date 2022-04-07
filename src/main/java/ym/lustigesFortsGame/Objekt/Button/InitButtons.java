package ym.lustigesFortsGame.Objekt.Button;

import lombok.Getter;

import java.util.ArrayList;

public class InitButtons {

    @Getter

    private ArrayList <ButtonTemplate> buttons = new ArrayList<>();
    private ButtonTemplate lokalButton;


    public InitButtons(){
        System.out.println("hi");
        lokalButton = new ButtonTemplate("Lokal PvP" , 500, 500,300,300,30,true) {
            @Override
            void onClick() {
                System.out.println("Starte spiel");
                    setAktive(false);
            }
        };
        buttons.add(lokalButton);
    }

    public ButtonTemplate getLokalButton() {
        return lokalButton;
    }
}
