package ym.lustigesFortsGame;

import lombok.Getter;
import lombok.Setter;
import ym.lustigesFortsGame.listener.KeyListeners;
import ym.lustigesFortsGame.utils.Images;
import ym.lustigesFortsGame.utils.Paths;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

public class GUI extends JFrame implements Runnable {
    private int SIZEX;
    private int SIZEY;

    private String titel = "Lustiges Forts Game";
    private Image dbImage = null;
    private Graphics dbg;
    private Font font;

    private Image backGroundImage ;

    public GUI( int SIZEX, int SIZEY) {
        this.SIZEX = SIZEX;
        this.SIZEY = SIZEY;

        setTitle(titel);
        //setUndecorated(true);

        setSize(new Dimension(SIZEX, SIZEY));
        addKeyListener(new KeyListeners());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(null);


    }

    public void paint(Graphics g){

        if(dbImage == null){
            dbImage = createImage(getSIZEX(),getSIZEY());
            dbg = dbImage.getGraphics();

            backGroundImage = Images.getBackGroundImage();

        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF); // Keine Ahnung mit Funktionierts
        Toolkit.getDefaultToolkit().sync();

        //Hintergrund
        dbg.drawImage(getBackGroundImage(), 0, 0, null);

        g.drawImage(dbImage,0,0,this);
    }


    @Override
    public void run() {
        while (true){
            repaint();
        }
    }
}
