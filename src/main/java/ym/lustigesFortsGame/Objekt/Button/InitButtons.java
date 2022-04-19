package ym.lustigesFortsGame.Objekt.Button;

import lombok.Getter;
import ym.lustigesFortsGame.Controll;

import java.util.ArrayList;

public class InitButtons {

    @Getter

    //-----------------Buttons-------------------
    private ArrayList <ButtonTemplate> startbuttons = new ArrayList<>();
    private ArrayList <ButtonTemplate> ingameOptionButtons = new ArrayList<>();
    private ButtonTemplate localButton;
    private ButtonTemplate onlineButton;
    private ButtonTemplate closeButton;
    private ButtonTemplate optionsButton;

    private ButtonTemplate returnMenue;

    private int midY;
    private int midX;
    private Controll controll;





    public InitButtons(int sizeX, int sizeY, Controll controll){
        this.controll = controll;
        getMid(sizeX,sizeY);


        //---------------------------Buttons fürs Startmenü-----------------------------------
        initStartmenue(sizeX,sizeY);




        //-------------------------Buttons fürs IngameOptionsmenü----------------------






    }

    private void initStartmenue(int sizeX,int sizeY) {
        int width = 300;
        int hight = 50;

        localButton = new ButtonTemplate("SingelPlayer" , midX -width/2, midY -hight/2-20,width,hight,30,true) {
            @Override
            void onClick() {
                setAktive(false);
                controll.startGame();

            }
        };
        onlineButton = new ButtonTemplate("Coming never", midX - width/2, midY - hight/2 +50,width,hight,30,true) {
            @Override
            void onClick() {
                setAktive(false);
            }
        };

        closeButton = new ButtonTemplate("X", sizeX-30,1,30,30,30,true) {
            @Override
            void onClick() {
                System.exit(0);
            }
        };

        optionsButton = new ButtonTemplate("Options",midX-(width-100)/2,midY+ 120,width-100, hight-10,25,true ) {
            @Override
            void onClick() {

            }
        };

        startbuttons.add(optionsButton);
        startbuttons.add(closeButton);
        startbuttons.add(onlineButton);
        startbuttons.add(localButton);
    }

    private void getMid(int sizeX, int sizeY){
        midX = sizeX /2;
        midY = sizeY /2;
    }

    public ButtonTemplate getLocalButton() {
        return localButton;
    }
}
