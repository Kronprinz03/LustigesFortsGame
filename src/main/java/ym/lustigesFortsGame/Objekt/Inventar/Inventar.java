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
    private Image invHolz;
    private Image invRettigSamen;
    private Image invRettig;

    //Objekte
    private Controll controll;


    //Varible
    private boolean aktive = false;
    private int schriftgröße =22;



    public Graphics draw (Graphics dbg){
        Font font;
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        String number;

        if(aktive){
            int tool = controll.getSpieler1().getTool();
            dbg.setColor(Color.BLACK);
            font = new Font("Tahoma", Font.BOLD, schriftgröße);
            dbg.setFont(font);
            // Inventory
            dbg.drawImage(invFeld,getPosX(),getPosY(),null);

            //-----------------------Ressources----------------------
            //holz
            dbg.drawImage(invHolz,getPosX()+2,getPosY()+75,null);
            number = Integer.toString(controll.getSpieler1().getBaum());
            dbg.drawString(number,getPosX()+2,getPosY()+105);

            //Rettig
            dbg.drawImage(invRettig,getPosX()+2,getPosY()+40,null);
            number = Integer.toString(controll.getSpieler1().getRettig());
            dbg.drawString(number,getPosX()+2,getPosY()+70);

            dbg.drawImage(invRettigSamen,getPosX()+2,getPosY(),null);
            number = Integer.toString(controll.getSpieler1().getRettigSamen());
            dbg.drawString(number,getPosX()+2,getPosY()+35);

            //---------------------------Tools--------------------------


            if(tool == 1){
                dbg.setColor(Color.red);
            }
            dbg.drawImage(invAxt,getPosX()+2,getPosY()+125,null);
            dbg.drawString("1",getPosX()+2,getPosY()+155);
            dbg.setColor(Color.BLACK);
            if(tool == 2){
                dbg.setColor(Color.red);
            }
            dbg.drawImage(invHoe,getPosX()+44,getPosY()+125,null);
            dbg.drawString("2",getPosX()+42,getPosY()+155) ;
            dbg.setColor(Color.BLACK);
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
        invHolz = Images.getHolz();
        invRettig = Images.getRettig();
        invRettigSamen = Images.getrSamen();
    }
}
