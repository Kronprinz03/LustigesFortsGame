package ym.lustigesFortsGame.utils;

import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Images {
@Getter
    private static Image backGroundImage = getSizedImage(Paths.hintergrund,1280,768 );


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
}
