package ym.lustigesFortsGame.Clocks;

import lombok.Setter;
import lombok.SneakyThrows;
import ym.lustigesFortsGame.Controll;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

@Setter
public class Playtime extends Thread {
    private int countdown;
    private Controll controll;
    private int index = 0;
    private int sizeX;
    private int sizeY;
    private double x;
private int wqerw = 0;



    public Playtime (int countdown, Controll controll, int index, int sizeX){
        this.countdown = countdown;
        this.controll = controll;
        this.index = index;

        this.sizeX = sizeX;


    }

    public Graphics Draw(Graphics dbg){
        double pixpPerS = sizeX / countdown;       // 60Pixel per 10.000ms = 6/1000 pixPerS
        x = pixpPerS * index;
        double width = sizeX-x;

        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        Font font;
        font = new Font("Tahoma", Font.PLAIN, 30);
        int textwidth = (int) (font.getStringBounds(Integer.toString(countdown-index), frc).getWidth()); // Breite der Schrift
        dbg.setFont(font);
        dbg.setColor(Color.red);
        dbg.drawString(Integer.toString(countdown-index),sizeX/2 - textwidth/2, 70);


        return dbg;
    }


    @SneakyThrows
    @Override
    public void run() {
            while (index < countdown) {
                if(controll.isIngame()&& !(controll.isPause())) {
                    Thread.sleep(1000);
                    index++;
                }else {
                    System.out.println();
                }
            }
            countdown = index;
            controll.getPunktescreen().aufrufenPunktescreeen();
    }
}
