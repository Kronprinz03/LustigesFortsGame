package ym.lustigesFortsGame.Objekt.Button;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

@Getter
@Setter

public abstract class ButtonTemplate extends JButton implements MouseListener, MouseMotionListener {
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected boolean pressed = false;
    protected boolean hover = false;
    protected boolean aktive= false;
    protected String name;
    protected int schriftgröße;



    public ButtonTemplate(String name, int x, int y, int width, int height, int schriftgröße, boolean activ) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.aktive = activ;
        this.schriftgröße = schriftgröße;
    }


    abstract void onClick();
    public Graphics draw (Graphics dbg){
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        Font font;
        if(isAktive()) {
            if (!isHover()) {
                dbg.setColor(Color.white);
                dbg.fillRect(this.x, this.y, this.width, this.height);
                dbg.setColor(Color.black);
                font = new Font("Tahoma", Font.PLAIN, schriftgröße);
                int textHeight = (int) (font.getStringBounds(name, frc).getHeight()+7); // höhe der SChrift
                int textwidth = (int) (font.getStringBounds(name, frc).getWidth()); // Breite der Schrift
                dbg.setFont(font);
                dbg.drawString(name, (getX() + (getWidth()/2)) - (textwidth / 2), (getY() + (getHeight()/2)) + (textHeight / 2) - 10);
            } else {
                dbg.setColor(Color.gray);
                dbg.fillRect(this.x, this.y, this.width, this.height);
                dbg.setColor(Color.white);
                font = new Font("Tahoma", Font.PLAIN, schriftgröße);
                int textHeight = (int) (font.getStringBounds(name, frc).getHeight()+7); // höhe der SChrift
                int textwidth = (int) (font.getStringBounds(name, frc).getWidth()); // Breite der Schrift
                dbg.setFont(font);
                dbg.drawString(name, (getX() + (getWidth()/2)) - (textwidth / 2), (getY() + (getHeight()/2)) + (textHeight / 2) - 10);
            }
        }
        return dbg;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(insideButton(e)){
            onClick();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(insideButton(e)){
            hover = true;
        }else{
            hover = false;
        }
    }

    private boolean insideButton(MouseEvent e){
        boolean insideButton = false;
        if(aktive){
            Point p = new Point(e.getPoint());
            Rectangle rectangle = new Rectangle(getX(), getY(), getWidth(), getHeight());
            if(rectangle.contains(p)){
                insideButton = true;
            }
        }
        return  insideButton;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }


}
