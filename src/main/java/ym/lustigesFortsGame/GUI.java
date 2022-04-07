package ym.lustigesFortsGame;

import lombok.Getter;
import lombok.Setter;
import ym.lustigesFortsGame.Objekt.Button.ButtonTemplate;
import ym.lustigesFortsGame.listener.KeyListeners;
import ym.lustigesFortsGame.utils.Images;
import ym.lustigesFortsGame.utils.Paths;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Getter
@Setter

public class GUI extends JFrame implements Runnable {
    private int SIZEX;
    private int SIZEY;

    private String titel = "Lustiges Forts Game";
    private Image dbImage = null;
    private Graphics dbg;
    private Font font;
    private Controll controll;


    private Image backGroundImage ;

    public GUI( int SIZEX, int SIZEY, Controll controll) {
        this.SIZEX = SIZEX;
        this.SIZEY = SIZEY;

        this.controll = controll;

        setTitle(titel);
        //setUndecorated(true);

        setSize(new Dimension(SIZEX, SIZEY));

        addListerner();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(null);


    }

    public void paint(Graphics g){
        System.out.println("GUI");
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


        dbg =  controll.getInitButtons().getLokalButton().draw(dbg);



        g.drawImage(dbImage,0,0,this);
    }

    public void addListerner(){
        addKeyListener(new KeyListeners());
        for (ButtonTemplate button : controll.getInitButtons().getButtons()){
            addMouseMotionListener(button);
            addMouseListener(button);
        }

    }

    @Override
    public void run() {
        while (true){
            repaint();
        }
    }
}
