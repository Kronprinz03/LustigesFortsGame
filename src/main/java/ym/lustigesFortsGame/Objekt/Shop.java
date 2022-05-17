package ym.lustigesFortsGame.Objekt;

import lombok.Getter;
import lombok.Setter;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.Objekt.Button.ButtonTemplate;
import ym.lustigesFortsGame.Objekt.Inventar.Inventar;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

@Setter
@Getter
public class Shop {
    private int x;
    private int y;
    private int width;
    private int height;
    private String titel = "Shop";


    private boolean aktive = false;
    private Image ananasSeed;
    private Image gurkenSeed;
    private Image rettigSeed;
    private Controll controll;

    private int geld = 0;


    private ArrayList <ButtonTemplate> shopButtons = new ArrayList<>();


    public Graphics draw (Graphics dbg){

        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);


        if(aktive) {
            //Hintergrund Shop
            dbg.setColor(Color.LIGHT_GRAY);
            dbg.fillRect(getX(), getY(), getWidth(), getHeight());

            //Schrift "Shop"
            dbg.setColor(Color.white);

            Font font;
            font = new Font("Tahoma", Font.PLAIN, 40);
            int textwidth = (int) (font.getStringBounds(titel, frc).getWidth()); // Breite der Schrift
            dbg.setFont(font);
            dbg.drawString(titel,(getX()+getWidth()/2)-textwidth/2,getY()+50);


            //Button
            for(ButtonTemplate button : getShopButtons()){
                button.draw(dbg);
            }

            //Bilder
            String ananas = "Ananas";
            String gurke = "Gurke";
            String rettig = "Rettig";


            Font font1 = new Font("Tahoma", Font.PLAIN, 25);
            int ananasW = (int) (font1.getStringBounds(ananas, frc).getWidth());
            int gurkeW = (int) (font1.getStringBounds(gurke, frc).getWidth());
            int rettigW = (int) (font1.getStringBounds(rettig, frc).getWidth());

            dbg.setFont(font1);
            dbg.setColor(Color.white);
            dbg.drawString(ananas,x+35,y+180);
            dbg.drawImage(ananasSeed,x+20,y+200,null);

            dbg.drawString(gurke,x+getWidth()/2-40,y+180);
            dbg.drawImage(gurkenSeed,x+getWidth()/2-50,y+200,null);

            dbg.drawString(rettig,x+getWidth()-100,y+180);
            dbg.drawImage(rettigSeed,x+width-120,y+200,null);



        }

        dbg.setColor(Color.YELLOW);
        Font font2 = new Font("Tahoma", Font.PLAIN, 20);
        dbg.setFont(font2);
        int textwidth = (int) (font2.getStringBounds(Integer.toString(geld), frc).getWidth()); // Breite der Schrift

        dbg.drawString(Integer.toString(geld),(controll.getSizeX()-70)-textwidth,60);
        dbg.drawImage(Images.getGeld(),controll.getSizeX()-70,42, null);

        return dbg;
    }



    public void sellAll(){
       Player spieler1 = controll.getSpieler1();

       int holz = spieler1.getBaum();
       int ananas = spieler1.getAnanas();
       int rettig = spieler1.getRettig();
       int gurke = spieler1.getGurke();

       spieler1.setBaum(0);
       spieler1.setRettig(0);
       spieler1.setGurke(0);
       spieler1.setAnanas(0);

       geld = geld + (holz *2) +(ananas * 5) +(rettig *8) +(gurke * 10);
    }

    public void sell(int id){
        Player spieler1 = controll.getSpieler1();
        switch (id){
            case 1:
                if(spieler1.getAnanas() > 0) {
                    spieler1.setAnanas(spieler1.getAnanas() - 1);
                    geld = geld + 5;
                }
                break;
            case 2:
                if(spieler1.getGurke() > 0){
                    spieler1.setGurke(spieler1.getGurke() - 1 );
                    geld = geld + 10;
                }

                break;

            case 3:
                if(spieler1.getRettig() > 0){
                    spieler1.setRettig(spieler1.getRettig() -1 );
                    geld = geld + 8;
                }
                break;
        }
    }

    public void buy (int id){
        Player spieler1 = controll.getSpieler1();
        switch (id){
            case 1:
                if(geld > 14){
                    geld = geld - 15;
                    spieler1.setAnanasSamen(spieler1.getAnanasSamen()+1);
                }
                break;

            case 2:
                if(geld > 4){
                    geld = geld - 5;
                    spieler1.setGurkenSamen(spieler1.getGurkenSamen()+1);
                }
                break;

            case 3:
                if(geld > 3){
                    geld = geld -4;
                    spieler1.setRettigSamen(spieler1.getRettigSamen()+1);
                }
                break;
        }


    }

    public void aufrufShop(){
        if(aktive){
            aktive = false;
            for(ButtonTemplate button : shopButtons){
                button.setAktive(false);
            }
        }else{
            aktive = true;
            for(ButtonTemplate button : shopButtons){
                button.setAktive(aktive);
            }
        }
    }

    public Shop(int x, int y, int width, int height, Controll controll) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        ananasSeed = Images.getaSamenS();
        gurkenSeed = Images.getgSamenS();
        rettigSeed = Images.getrSamenS();

        this.controll =controll;
    }
}
