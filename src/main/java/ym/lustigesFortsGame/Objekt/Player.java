package ym.lustigesFortsGame.Objekt;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.enums.Direaction;
import ym.lustigesFortsGame.enums.Movment;
import ym.lustigesFortsGame.map.plants.Ananas;
import ym.lustigesFortsGame.map.plants.Gurke;
import ym.lustigesFortsGame.map.plants.Plant;
import ym.lustigesFortsGame.map.plants.Rettig;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;
import java.util.Random;


@Getter
@Setter

public class Player {
    //Positionen
    private int posX;
    private int posY;

    private int nextPosX1;
    private int nextPosY1;

    private int nextPosX2;
    private int nextPosY2;

    private int harvestX;
    private int harvestY;


    private int width;
    private int height;

    //Enum
    private Direaction direaction = Direaction.unten;
    private Movment movment = Movment.stop;


    //Inventar
    private int rettig = 0;
    private int ingRettig = 0;
    private int rettigSamen = 1;

    private int ananas = 0;
    private int ingAnanas;
    private int ananasSamen = 1;

    private int gurke = 0;
    private int ingGurke = 0;
    private int gurkenSamen = 1;

    private int seedOpt;

    private int baum = 0;
    private int ingBaum = 0;

    //Attribut
    private Image laufImage = null;
    private int tool = 1;
    private boolean harvesting = false;

    private int energy = 100;

    private int maxDrop = 2;
    private int minDrop = 1;

    //Objekte
    Controll controll;


    public Player(int posX, int posY, int width, int height, Controll controll) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height-5;
        this.controll = controll;
    }

    public Graphics draw (Graphics dbg){


        // wenn der Spieler steht
       if(getMovment() == Movment.stop) {
            if (getDireaction() == Direaction.oben) {
                dbg.drawImage(Images.getOben1(), getPosX(), getPosY(), null);
            }
            if (getDireaction() == Direaction.unten) {
                dbg.drawImage(Images.getUnten1(), getPosX(), getPosY(), null);
            }
            if (getDireaction() == Direaction.rechts) {
                dbg.drawImage(Images.getRechts1(), getPosX(), getPosY(), null);
            }
            if (getDireaction() == Direaction.links) {
                dbg.drawImage(Images.getLinks1(), getPosX(), getPosY(), null);
            }
       }else {
           dbg.drawImage(getLaufImage(),getPosX(),getPosY(),null);
       }

       dbg.setColor(Color.white);
       dbg.fillRect(1000,80,200,10);
       dbg.setColor(Color.YELLOW);
       dbg.fillRect((200-energy*2) + 1000,80,energy*2,10);


        return dbg;
    }



    public boolean isMoveOkay() {

        boolean moveOkay = true;
        int collision[][] = controll.getMap().getInputCollision();
        nextHitbox();

        int nextXFeld1 = nextPosX1/40;
        int nextYFeld1 = nextPosY1/40;

        int nextXFeld2 = nextPosX2/40;
        int nextYFeld2 = nextPosY2/40;


        if((collision[nextXFeld1][nextYFeld1] != 0) || (collision[nextXFeld2][nextYFeld2] != 0)){
            moveOkay = false;
        }


        return moveOkay;
    } // Schaut ob der Spieler laufen kann

    public void theHarvest(){
        if(energy > 4 && (controll.isIngame())&&!(controll.isPause())) {

            int xFeld = (getPosX() + (getWidth() / 2)) / 40;
            int yFeld = (getPosY() + getHeight() / 2) / 40;

            if (direaction == Direaction.oben) {
                yFeld--;
            }
            if (direaction == Direaction.links) {
                xFeld--;
            }
            if (direaction == Direaction.rechts) {
                xFeld++;
            }
            if (direaction == Direaction.unten) {
                yFeld++;
            }

            harvestY = yFeld;
            harvestX = xFeld;


            energy = energy - 5;


            int mapObjekt = controll.getMap().getMap(xFeld, yFeld);
            if (mapObjekt == 0) {
                int overlayObjekt = controll.getMap().getOverlay(xFeld, yFeld);
                if ((overlayObjekt == 0) && (getTool() == 2)) {
                    controll.getMap().setOverlay(xFeld, yFeld, 4);
                }

                if (((overlayObjekt == 1) || (overlayObjekt == 2)) && (getTool() == 1)) {
                    Random r = new Random();
                    int value = r.nextInt(minDrop + maxDrop) + minDrop;
                    baum = baum + value;
                    ingBaum = ingBaum + value;
                    controll.getMap().setOverlay(xFeld, yFeld, 0);
                    controll.getMap().setInputCollision(xFeld, yFeld, 0);
                }
                for (int i = 0; i < controll.getMap().getPlants().size(); i++) {
                    Plant plant = controll.getMap().getPlants().get(i);
                    int plX = plant.getXFeld();
                    int plY = plant.getYFeld();

                    if ((plX == xFeld) && (plY == yFeld) && (plant.isFinish())) {
                        plant.harvest(this);
                    }
                }
            }
        }
    } // Ablauf wenn der Spieler Axt oder Tool benutzt

    public void plant(){
        if(!(controll.isPause()) && controll.isIngame()){
        int xFeld = (getPosX()+(getWidth()/2))/40;
        int yFeld = (getPosY()+getHeight()/2)/40;

        if(direaction == Direaction.oben){
            yFeld--;
        }
        if(direaction == Direaction.links){
            xFeld--;
        }
        if(direaction == Direaction.rechts){
            xFeld++;
        }
        if(direaction == Direaction.unten){
            yFeld++;
        }
        if((controll.getMap().getOverlay(xFeld,yFeld) == 4) && (controll.getMap().isTherePlant(xFeld,yFeld))) {

            switch (seedOpt) {
                case 0:
                    if (getRettigSamen() > 0) {
                        Rettig rettig = new Rettig(xFeld, yFeld, controll);
                        controll.getMap().getPlants().add(rettig);
                        setRettigSamen(getRettigSamen() - 1);
                    }
                    break;

                case 1:
                    if (getAnanasSamen() > 0) {
                        Ananas ananas = new Ananas(xFeld, yFeld, controll);
                        controll.getMap().getPlants().add(ananas);
                        setAnanasSamen(getAnanasSamen() - 1);
                    }
                    break;
                case 2:
                    if (getGurkenSamen() > 0) {
                        Gurke gurke = new Gurke(xFeld, yFeld, controll);
                        controll.getMap().getPlants().add(gurke);
                        setGurkenSamen(getGurkenSamen() - 1);
                    }
                    break;
                }
            }
        }
    }

    private void nextHitbox(){

        nextPosX1 = getPosX();
        nextPosY1 = getPosY();

        nextPosX2 = getPosX();
        nextPosY2 = getPosY();

        int hitboxwidth = getWidth() -5;


        if(direaction == Direaction.links){
            nextPosX1 -= 5;
            nextPosX2 -= 5;
            nextPosY2 += getHeight();
        }
        if(direaction == Direaction.rechts){
            nextPosX1 += 5 + getWidth();
            nextPosY1 += 5 + getWidth();
            nextPosY2 += getHeight();

        }
        if(direaction == Direaction.oben){
            nextPosY1 -=5;
            nextPosY2 -=5;
            nextPosX2 += getWidth();
        }
        if(direaction == Direaction.unten){
            nextPosY1 +=5 + getHeight();
            nextPosY2 +=5 + getHeight();
            nextPosX2 += getWidth();
        }

    } //berechnet die Hitbox der nächsten Bewegung

    public void setDireaction(Direaction direaction) {
        this.direaction = direaction;
        loadharvest();
    }

    public void loadharvest() {
        int xFeld = (getPosX()+(getWidth()/2))/40;
        int yFeld = (getPosY()+getHeight()/2)/40;

        if(direaction == Direaction.oben){
            yFeld--;
        }
        if(direaction == Direaction.links){
            xFeld--;
        }
        if(direaction == Direaction.rechts){
            xFeld++;
        }
        if(direaction == Direaction.unten){
            yFeld++;
        }

        harvestY = yFeld;
        harvestX = xFeld;
    }
}
