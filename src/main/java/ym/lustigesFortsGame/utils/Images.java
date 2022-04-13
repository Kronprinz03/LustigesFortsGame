package ym.lustigesFortsGame.utils;

import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
@Getter
public class Images {
@Getter
    private static Image backGroundImage = getSizedImage(Paths.hintergrund,1280,768 );




    //-----------------------Spieler-------------------------
    private static Image unten1 =getSizedImage(Paths.punten1,20,40);
    private static Image oben1 =getSizedImage(Paths.poben1,20,40);
    private static Image rechts1 =getSizedImage(Paths.prechts1,20,40);
    private static Image links1 =getSizedImage(Paths.plinks1,20,40);

    private static Image unten2 =getSizedImage(Paths.punten2,20,40);
    private static Image oben2 =getSizedImage(Paths.poben2,20,40);
    private static Image rechts2 =getSizedImage(Paths.prechts2,20,40);
    private static Image links2 =getSizedImage(Paths.plinks2,20,40);

    private static Image unten3 =getSizedImage(Paths.punten3,20,40);
    private static Image oben3 =getSizedImage(Paths.poben3,20,40);
    private static Image rechts3 =getSizedImage(Paths.prechts3,20,40);
    private static Image links3 =getSizedImage(Paths.plinks3,20,40);

    //-------------------------------Map-------------------------------
    private static Image grass = getSizedImage(Paths.pgrass,40,40);
    private static Image duenger = getSizedImage(Paths.pduenger,40,40);

    private static Image baum1 = getSizedImage(Paths.pbaum1,40,40);
    private static Image baum2 = getSizedImage(Paths.pbaum2,40,40);
    private static Image baum3 = getSizedImage(Paths.pbaum3,40,40);
    private static Image steinweg = getSizedImage(Paths.pSteinweg,40,40);



    public static Image getSizedImage(File file, int SizeX, int SizeY) {
        Image changedImage = null; // Image smalling
        try {
            Image img = ImageIO.read(file); // Image inizialisieren aus der PNG datei (Dunkle Magie)
            changedImage = img.getScaledInstance(SizeX, SizeY, Image.SCALE_FAST);
        } catch (IOException e) {
            System.out.println("BILD WURDE NICHT GEFUNDEN!");
        }
        return changedImage;
    }

    public static Image getDuenger() {
        return duenger;
    }

    public static Image getBaum1() {
        return baum1;
    }

    public static Image getBaum2() {
        return baum2;
    }

    public static Image getBaum3() {
        return baum3;
    }

    public static Image getSteinweg() {
        return steinweg;
    }

    public static Image getGrass() {
        return grass;
    }

    public static Image getUnten2() {
        return unten2;
    }

    public static Image getOben2() {
        return oben2;
    }

    public static Image getRechts2() {
        return rechts2;
    }

    public static Image getLinks2() {
        return links2;
    }

    public static Image getUnten3() {
        return unten3;
    }

    public static Image getOben3() {
        return oben3;
    }

    public static Image getRechts3() {
        return rechts3;
    }

    public static Image getLinks3() {
        return links3;
    }

    public static Image getOben1() {
        return oben1;
    }

    public static Image getUnten1() {
        return unten1;
    }

    public static Image getRechts1() {
        return rechts1;
    }

    public static Image getLinks1() {
        return links1;
    }
}
