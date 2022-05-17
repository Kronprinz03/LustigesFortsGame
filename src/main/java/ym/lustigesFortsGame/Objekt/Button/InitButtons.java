package ym.lustigesFortsGame.Objekt.Button;

import lombok.Getter;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Punktescreen;

import java.util.ArrayList;
@Getter
public class InitButtons {


    //-----------------Buttons-------------------
    private ArrayList <ButtonTemplate> startbuttons = new ArrayList<>();
    private ArrayList <ButtonTemplate> ingameOptionButtons = new ArrayList<>();
    private ButtonTemplate localButton;
    private ButtonTemplate onlineButton;
    private ButtonTemplate closeButton;
    private ButtonTemplate optionsButton;

    private ButtonTemplate sellAll;
    private ButtonTemplate buyAnanasSeed;
    private ButtonTemplate buyGurkenSeed;
    private ButtonTemplate buyRettigSeed;

    private ButtonTemplate sellAnanasSeed;
    private ButtonTemplate sellGurkenSeed;
    private ButtonTemplate sellRettigSeed;

    private ButtonTemplate returnMenue;

    private int midY;
    private int midX;
    private Controll controll;





    public InitButtons(int sizeX, int sizeY, Controll controll){
        this.controll = controll;
        getMid(sizeX,sizeY);


        //---------------------------Buttons fürs Startmenü-----------------
        initStartmenue(sizeX,sizeY);


        //-------------------------Buttons fürs Ingame----------------------
        initShopButton();


        //-------------------------Button für Endscreen---------------------


    }

    private void initShopButton(){
        int x = controll.getShop().getX();
        int y = controll.getShop().getY();
        int width = controll.getShop().getWidth();
        int height = controll.getShop().getHeight();

        ArrayList <ButtonTemplate> arrayShopButton = controll.getShop().getShopButtons();

        sellAnanasSeed = new ButtonTemplate("Sell", x+20, y +350, 50,30,20,false) {
            @Override
            void onClick() {
                controll.getShop().sell(1);
            }
        };

        buyAnanasSeed = new ButtonTemplate("Buy",x+80,y+350, 50,30,20,false) {
            @Override
            void onClick() {
                controll.getShop().buy(1);
            }
        };

        sellGurkenSeed = new ButtonTemplate("Sell",(x+width/2)-55,y+350,50,30,20,false) {
            @Override
            void onClick() {
                controll.getShop().sell(2);
            }
        };

        buyGurkenSeed = new ButtonTemplate("Buy",(x+width/2)+5,y+350,50,30,20,false) {
            @Override
            void onClick() {
                controll.getShop().buy(2);
            }
        };

        sellRettigSeed = new ButtonTemplate("Sell", (x+width)-50-80,y+350,50,30,20,false) {
            @Override
            void onClick() {
                controll.getShop().sell(3);
            }
        };

        buyRettigSeed = new ButtonTemplate("Buy", (x+width)-20-50,y+350,50,30,20,false) {
            @Override
            void onClick() {
                controll.getShop().buy(3);
            }
        };


        sellAll = new ButtonTemplate("Sell All", x+20,y+height-100,width-40,50,20,false) {
            @Override
            void onClick() {
                controll.getShop().sellAll();
            }
        };

        arrayShopButton.add(sellAll);
        arrayShopButton.add(sellAnanasSeed);
        arrayShopButton.add(buyAnanasSeed);

        arrayShopButton.add(buyGurkenSeed);
        arrayShopButton.add(sellGurkenSeed);

        arrayShopButton.add(sellRettigSeed);
        arrayShopButton.add(buyRettigSeed);
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

    public ButtonTemplate returnMenue(){
        Punktescreen p = controll.getPunktescreen();
        returnMenue = new ButtonTemplate("Hauptmenü",p.getX()+ 30,p.getY()+500,p.getWidth()-60,50,30,false) {
            @Override
            void onClick() {
                controll.beendeSpiel();
                aktive = false;
            }
        };

        return returnMenue;
    }

    public ButtonTemplate getLocalButton() {
        return localButton;
    }
}
