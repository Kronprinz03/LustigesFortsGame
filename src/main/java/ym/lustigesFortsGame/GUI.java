package ym.lustigesFortsGame;

import lombok.Getter;
import lombok.Setter;
import ym.lustigesFortsGame.Objekt.Button.ButtonTemplate;
import ym.lustigesFortsGame.listener.KeyListeners;
import ym.lustigesFortsGame.listener.MouseListener;
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
    private Controll controll;

    private boolean ingame = false;


    private Image backGroundImage ;

    public GUI( int SIZEX, int SIZEY, Controll controll) {
        this.SIZEX = SIZEX;
        this.SIZEY = SIZEY;

        this.controll = controll;
        setUndecorated(true);

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
        if(dbImage == null){
            dbImage = createImage(getSIZEX(),getSIZEY());
            dbg = dbImage.getGraphics();

            backGroundImage = Images.getBackGroundImage();

        }
        //---------------------------Start---------------------------
        if(!ingame) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF); // Keine Ahnung mit Funktionierts
            Toolkit.getDefaultToolkit().sync();

            //Hintergrund
            dbg.drawImage(getBackGroundImage(), 0, 0, null);

            for (ButtonTemplate button : controll.getInitButtons().getStartbuttons()) {
                dbg = button.draw(dbg);
            }
        }
        //--------------------INGAME--------------------------
        if(ingame) {


            //------------------------------------MAP-----------------------------

            //Hintergrund
            dbg.setColor(Color.black);
            dbg.fillRect(0, 0, getSIZEX(), getSIZEY());





            //----Spieler----
            dbg.setColor(Color.white);
            dbg = controll.getMap().draw(dbg);
            dbg = controll.getSpieler1().draw(dbg);


            dbg = controll.getInventar().draw(dbg);




        }



        g.drawImage(dbImage,0,0,this);
    }

    public void addListerner(){
        addKeyListener(new KeyListeners(controll));
        addMouseListener(new MouseListener(controll));
        for (ButtonTemplate button : controll.getInitButtons().getStartbuttons()){
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
