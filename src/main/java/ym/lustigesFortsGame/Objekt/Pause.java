package ym.lustigesFortsGame.Objekt;

import lombok.Getter;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Button.ButtonTemplate;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

@Getter
public class Pause {
    private int x;
    private int y;
    private int width;
    private int height;
    private String titel = "Pause";
    private Controll controll;

    private ButtonTemplate returnButton;



    public Graphics draw (Graphics dbg){
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);

        if(controll.isPause()){
            dbg.setColor(Color.BLACK);
            dbg.fillRect(x,y,width,height);

            dbg.setColor(Color.white);
            Font font = new Font("Tahoma", Font.PLAIN, 35);
            int textwidth = (int) (font.getStringBounds(titel, frc).getWidth()); // Breite der Schrift
            dbg.setFont(font);
            dbg.drawString(titel,getX()+getWidth()/2 -textwidth/2,getY()+50);

            returnButton.draw(dbg);
        }
        return dbg;
    }


    public void  aufrufPause(){
        if (controll.isPause()) {
            controll.setPause(false);
            returnButton.setAktive(false);
        } else {
            if(controll.isIngame()) {
                controll.setPause(true);
                returnButton.setAktive(true);
            }
        }
    }

    public Pause(int x, int y, int width, int height, Controll controll) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.controll = controll;

        returnButton = controll.getInitButtons().returnMenue();
        controll.getGui().addMous(returnButton);
    }
}
