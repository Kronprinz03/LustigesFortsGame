package ym.lustigesFortsGame.Objekt;

import lombok.Getter;
import lombok.Setter;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Button.ButtonTemplate;
import ym.lustigesFortsGame.map.plants.Ananas;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
@Getter
@Setter
public class Punktescreen {
    private int x;
    private int y;
    private int width;
    private int height;
    private String titel = "Zeit ist Abgelaufen";
    private boolean aktive = false;

    private Controll controll;


    //Rechnungen
    private int gurke;
    private int ananas;
    private int rettig;
    private int holz;
    private int geld;

    ButtonTemplate returnMenue;

    private int pGurke;
    private int pAnanas;
    private int pRettig;
    private int pGeld;
    private int pHolz;

    private int ingPunkte;

    public Graphics draw (Graphics dbg){
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);

        if(aktive) {
            dbg.setColor(Color.BLACK);
            dbg.fillRect(x, y, width, height);
            String text = "Endpunktestand";


            dbg.setColor(Color.white);
            Font font = new Font("Tahoma", Font.PLAIN, 35);
            int textwidth = (int) (font.getStringBounds(text, frc).getWidth()); // Breite der Schrift
            dbg.setFont(font);
            dbg.drawString(text,(getX()+getWidth()/2)-textwidth/2,getY()+50);


            text = "Gegenstände";
            font = new Font("Tahoma", Font.PLAIN, 20);
            dbg.setFont(font);
            dbg.drawString(text,getX()+20,getY()+100);

            text = "Holz";
            dbg.drawString(text,getX()+20,getY()+180);

            text = "Ananas";
            dbg.drawString(text,getX()+20,getY()+220);

            text = "Gurke";
            dbg.drawString(text,getX()+20,getY()+260);

            text = "Rettig";
            dbg.drawString(text,getX()+20,getY()+300);

            text = "Geld";
            dbg.drawString(text,getX()+20,getY()+340);

            text = "Insgesamt";
            dbg.drawString(text,getX()+width/2 -60,getY()+100);

            text = Integer.toString(holz);
            dbg.drawString(text,getX()+width/2 -60,getY()+180);

            text = Integer.toString(ananas);
            dbg.drawString(text,getX()+width/2 -60,getY()+220);

            text = Integer.toString(gurke);
            dbg.drawString(text,getX()+width/2 -60,getY()+260);

            text = Integer.toString(rettig);
            dbg.drawString(text,getX()+width/2 -60,getY()+300);

            text = Integer.toString(geld);
            dbg.drawString(text,getX()+width/2 -60,getY()+340);

            text = "Punkte";
            dbg.drawString(text,getX()+width -140,getY()+100);

            text = Integer.toString(pHolz);
            dbg.drawString(text,getX()+width -140,getY()+180);

            text = Integer.toString(pAnanas);
            dbg.drawString(text,getX()+width -140,getY()+220);

            text = Integer.toString(pGurke);
            dbg.drawString(text,getX()+width -140,getY()+260);

            text = Integer.toString(pRettig);
            dbg.drawString(text,getX()+width -140,getY()+300);

            text = Integer.toString(pGeld);
            dbg.drawString(text,getX()+width -140,getY()+340);

            dbg.drawRect(getX(),getY()+380, getWidth(),0);
            dbg.drawRect(getX(),getY()+384, getWidth(),0);


            text = "Endstand:";
            font = new Font("Tahoma", Font.PLAIN, 20);
            textwidth = (int) (font.getStringBounds(text, frc).getWidth());
            dbg.setFont(font);

            dbg.drawString(text,getX()+getWidth()/2-60,getY()+450);

            text = Integer.toString(ingPunkte);
            dbg.drawString(text,getX()+width -140,getY()+450);

            returnMenue.draw(dbg);

        }
        return dbg;
    }


    private void berechnePunkte(){
        Player s = controll.getSpieler1();
        gurke = s.getIngGurke();
        ananas = s.getIngAnanas();
        rettig = s.getIngRettig();
        holz = s.getIngBaum();

        geld = controll.getShop().getGeld();

        pHolz = holz * 2;
        pGurke = gurke * 3;
        pAnanas = ananas *3;
        pRettig = rettig*3;
        pGeld = geld*10;

        ingPunkte = pHolz + pGurke + pAnanas + pRettig + pGeld;
    }

    public void aufrufenPunktescreeen(){
        if(aktive){
            aktive = false;
            if(!(returnMenue == null)){
                returnMenue.setAktive(false);
            }

        }else {
            aktive = true;
            returnMenue = controll.getInitButtons().returnMenue();
            controll.getGui().addMous(returnMenue);
            returnMenue.setAktive(true);
            controll.setIngame(false);
            controll.getShop().sellAll();
            berechnePunkte();
        }
    }

    public Punktescreen(int x, int y, int width, int height, Controll controll) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.controll = controll;
    }
}
