package ym.lustigesFortsGame.Objekt.Inventar;



import lombok.Getter;
import lombok.Setter;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

@Getter
@Setter

public class Inventar {

    //Pos
    private int posX;
    private int posY;

    private int width;
    private int height;


    //Bilder
    private Image invFeld;
    private Image invAxt;
    private Image invHoe;

    //Objekte
    private Controll controll;


    //Varible
    private boolean aktive = false;
    private int schriftgröße =15;



    public Graphics draw (Graphics dbg){
        Font font;
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);

        if(aktive){
            int tool = controll.getSpieler1().getTool();
            dbg.setColor(Color.white);
            font = new Font("Tahoma", Font.PLAIN, schriftgröße);
            dbg.setFont(font);
            if(tool == 1){
             dbg.setColor(Color.red);
            }
            // Inventory
            dbg.drawImage(invFeld,getPosX(),getPosY(),null);

            //---------------------------Iteams--------------------------
            dbg.drawImage(invAxt,getPosX()+2,getPosY()+125,null);
            dbg.drawString("1",getPosX()+2,getPosY()+155);
            dbg.setColor(Color.white);
            if(tool == 2){
                dbg.setColor(Color.red);
            }
            dbg.drawImage(invHoe,getPosX()+44,getPosY()+125,null);
            dbg.drawString("2",getPosX()+42,getPosY()+155) ;
            dbg.setColor(Color.white);
        }
        return dbg;
    }


    public Inventar(int posX, int posY, int width, int height, Controll controll) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.controll = controll;

        invFeld = Images.getInventar();
        invAxt = Images.getAxt();
        invHoe = Images.getHoe();
    }
}
