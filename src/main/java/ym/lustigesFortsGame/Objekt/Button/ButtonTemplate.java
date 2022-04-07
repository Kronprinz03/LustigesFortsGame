package ym.lustigesFortsGame.Objekt.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
