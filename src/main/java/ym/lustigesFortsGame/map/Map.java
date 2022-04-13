package ym.lustigesFortsGame.map;

import lombok.Getter;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

@Getter
public class Map {
    //Borders
    private int maxXgraphic;
    private int maxYgraphic;


    //-------------------MAP-Elemente--------------
    private Image elementeH[];
    private Image elementeV[];

    //Auslesehen
    private int inputMap[][];
    private int inputOverlay[][];


    public Map(Controll controll){
        maxXgraphic = 31;
        maxYgraphic = 18;

        // Interger für die Map
        inputMap = new int[getMaxXgraphic()][getMaxYgraphic()];
        inputOverlay = new int[getMaxXgraphic()][getMaxYgraphic()];

        //-----------Speicher der Elemente --------------------
        elementeH = new Image[2];
        elementeH[0] = Images.getGrass();
        elementeH[1] = Images.getDuenger();

        elementeV = new Image[5];
        elementeV[0] = null;
        elementeV[1] = Images.getBaum1();
        elementeV[2] = Images.getBaum2();
        elementeV[3] = Images.getBaum3();
        elementeV[4] = Images.getSteinweg();


        //--------------------Lade Map-----------------
        loadMap();
        loadOverlay();

    }


    public Graphics draw (Graphics dbg){

        int countX = 0;
        int countY = 0;
        int x = 0;
        int y = 0;



        while (countY < getMaxYgraphic() && countX < getMaxXgraphic()) {
            dbg.drawImage(elementeH[inputMap[countX][countY]], x, y, null);
            dbg.drawImage(elementeV[inputOverlay[countX][countY]], x, y, null);

            countX++;
            x = x +40;
            if(countX == 31){
                countX = 0;
                x = 0;
                countY++;
                y = y + 40;
            }
        }

        return dbg;
    }


    public void loadMap() {


        //---------------------------------MAP-------------------------
        File map = new File("src/main/java/ym/lustigesFortsGame/txtmap/Map01.txt");
        Scanner scan = null;
        String line;
        try {
            scan = new Scanner(map);
        }catch (Exception e){
            System.out.println("keine Map gefunden");
        }
        int countX = 0;
        int countY = 0;
        while (scan.hasNext() && countY < getMaxYgraphic()) {
            line = scan.nextLine();

            while (countX < getMaxXgraphic() ) {
                String numberString[] = line.split(" ");
                int number = Integer.parseInt(numberString[countX]);
                inputMap[countX][countY] = number;
                countX = countX + 1;
            }

            if (countX == getMaxXgraphic()) {
                countX = 0;
                countY = countY + 1;
            }
        }
        scan.close();
    }


    public void loadOverlay()  {
        // Overlay
        File overlay = new File("src/main/java/ym/lustigesFortsGame/txtmap/Overlay.txt");
        Scanner scOverlay = null;
        try {
             scOverlay = new Scanner(overlay);
        }catch ( Exception e){
            System.out.println("kein Overlay gefunden");
        }




        int countX = 0;
        int countY = 0;
        String line;

        while (scOverlay.hasNext() && countY < getMaxYgraphic()) {
            line = scOverlay.nextLine();


            while (countX < getMaxXgraphic()) {
                String numberString[] = line.split(" ");
                int number = Integer.parseInt(numberString[countX]);
                inputOverlay[countX][countY] = number;
                countX = countX + 1;
            }

            if (countX == getMaxXgraphic()) {
                countX = 0;
                countY = countY + 1;
            }

        }

        scOverlay.close();

    }
}
