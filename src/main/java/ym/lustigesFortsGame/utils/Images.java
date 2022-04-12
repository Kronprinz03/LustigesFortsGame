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

    private static Image unten1 =getSizedImage(Paths.punten1,20,40);
    private static Image oben1 =getSizedImage(Paths.poben1,20,40);
    private static Image rechts1 =getSizedImage(Paths.prechts1,20,40);
    private static Image links1 =getSizedImage(Paths.plinks1,20,40);


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
