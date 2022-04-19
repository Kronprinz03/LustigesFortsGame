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
    private static Image water = getSizedImage(Paths.pWater,40,40);

    private static Image baum1 = getSizedImage(Paths.pbaum1,40,40);
    private static Image baum2 = getSizedImage(Paths.pbaum2,40,40);
    private static Image baum3 = getSizedImage(Paths.pbaum3,40,40);
    private static Image steinweg = getSizedImage(Paths.pSteinweg,40,40);

    //---------------------------Inventar--------------------
    private static Image inventar = getSizedImage(Paths.pInventar,120,160);
    private static Image hoe = getSizedImage(Paths.pHoe,35,35);
    private static Image axt  = getSizedImage(Paths.pAxt,35,35);
    private static Image holz  = getSizedImage(Paths.pHolz,35,35);

    private static Image rSamen  = getSizedImage(Paths.pSamenRettig,35,35);
    private static Image rettig  = getSizedImage(Paths.pRettig,35,35);

    private static Image aSamen  = getSizedImage(Paths.pSamenAnanas,35,35);
    private static Image ananas  = getSizedImage(Paths.pAnanas,35,35);

    private static Image gSamen  = getSizedImage(Paths.pSamenGurke,35,35);
    private static Image gurke  = getSizedImage(Paths.pGurke,35,35);

    //-------------------------Plants------------------------
    private static Image ananas0  = getSizedImage(Paths.pAnanas0,35  ,35);
    private static Image ananas1  = getSizedImage(Paths.pAnanas1,40  ,40);
    private static Image ananas2  = getSizedImage(Paths.pAnanas2,40  ,40);
    private static Image ananas3  = getSizedImage(Paths.pAnanas3,40  ,40);

    private static Image gurke0  = getSizedImage(Paths.pGurke0,35  ,35);
    private static Image gurke1  = getSizedImage(Paths.pGurke1,40  ,40);
    private static Image gurke2  = getSizedImage(Paths.pGurke2,40  ,40);

    private static Image rettig0  = getSizedImage(Paths.pRettig0,35  ,35);
    private static Image rettig1  = getSizedImage(Paths.pRettig1,40  ,40);
    private static Image rettig2  = getSizedImage(Paths.pRettig2,40  ,40);


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

    public static Image getaSamen() {
        return aSamen;
    }

    public static Image getAnanas() {
        return ananas;
    }

    public static Image getgSamen() {
        return gSamen;
    }

    public static Image getGurke() {
        return gurke;
    }

    public static Image getAnanas0() {
        return ananas0;
    }

    public static Image getAnanas1() {
        return ananas1;
    }

    public static Image getAnanas2() {
        return ananas2;
    }

    public static Image getAnanas3() {
        return ananas3;
    }

    public static Image getGurke0() {
        return gurke0;
    }

    public static Image getGurke1() {
        return gurke1;
    }

    public static Image getGurke2() {
        return gurke2;
    }

    public static Image getBackGroundImage() {
        return backGroundImage;
    }

    public static Image getrSamen() {
        return rSamen;
    }

    public static Image getRettig() {
        return rettig;
    }

    public static Image getRettig0() {
        return rettig0;
    }

    public static Image getRettig1() {
        return rettig1;
    }

    public static Image getRettig2() {
        return rettig2;
    }

    public static Image getHolz() {
        return holz;
    }

    public static Image getInventar() {
        return inventar;
    }

    public static Image getHoe() {
        return hoe;
    }

    public static Image getAxt() {
        return axt;
    }

    public static Image getWater() {
        return water;
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
