package ym.lustigesFortsGame.Objekt;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.enums.Direaction;
import ym.lustigesFortsGame.enums.Movment;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;



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


    private int width;
    private int height;

    //Enum
    private Direaction direaction = Direaction.unten;
    private Movment movment = Movment.stop;


    //Inventar

    private int baum = 0;

    //Attribut
    private Image laufImage = null;
    private int tool = 1;
    private boolean harvesting = false;

    //Objekte
    Controll controll;


    public Player(int posX, int posY, int width, int height, Controll controll) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
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

        return dbg;
    }

    public boolean isMoveOkay() {

        boolean moveOkay = true;
        int collision[][] = controll.getMap().getInputCollision();
        Rectangle playerhitbox = nextHitbox();


        int xFeld = getPosX()/40;
        int yFeld = getPosY()/40;

        int nextxFeld;
        int nextyFeld;

        nextxFeld = (getNextPosX1())/40;
        nextyFeld = (getNextPosY1())/40;

        if(!(collision[nextxFeld][nextyFeld] == 0)){
            moveOkay = false;
        }
        if(movment == Movment.nachrechts || movment == Movment.nachlinks){
            int nextyFeld2 = (getNextPosY2()-5)/40;


            if(!(collision[nextxFeld][nextyFeld2] == 0)){
                moveOkay = false;
            }
        }


        return moveOkay;
    } // Schaut ob der Spieler laufen kann

    public void theHarvest(){
        int xFeld = getPosX()/40;
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

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                setHarvesting(true);
                Thread.sleep(2000);
                setHarvesting(false);
            }
        }).run();
        int mapObjekt = controll.getMap().getMap(xFeld,yFeld);
        if(mapObjekt == 0){
            int overlayObjekt = controll.getMap().getOverlay(xFeld,yFeld);
            if((overlayObjekt == 0) && (getTool() == 2)){
                controll.getMap().setOverlay(xFeld,yFeld,4);
            }

            if(((overlayObjekt == 1) || (overlayObjekt == 2)) &&(getTool() == 1)) {
                baum = baum + 5;
                controll.getMap().setOverlay(xFeld,yFeld,0);
                controll.getMap().setInputCollision(xFeld,yFeld,0);
            }


        }




    } // Ablauf wenn der Spieler Axt oder Tool benutzt

    private Rectangle nextHitbox(){

        nextPosX1 = getPosX();
        nextPosY1 = getPosY();

        nextPosX2 = getPosX();
        nextPosY2 = getPosY();

        if(direaction == Direaction.links){
            nextPosX1 -= 5;
            nextPosY2 += getHeight();
        }
        if(direaction == Direaction.rechts){
            nextPosX1 += 5+ getWidth();
            nextPosY2 += getHeight();

        }
        if(direaction == Direaction.oben){
            nextPosY1 -=5;
        }
        if(direaction == Direaction.unten){
            nextPosY1 +=5 + getHeight();
        }


        Rectangle playerHitbox = new Rectangle(nextPosX1, nextPosY1,getWidth(),getHeight());
        return playerHitbox;
    } //berechnet die Hitbox der nächsten Bewegung
}
