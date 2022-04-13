package ym.lustigesFortsGame.map;

import lombok.Getter;
import ym.lustigesFortsGame.Controll;
import ym.lustigesFortsGame.utils.Images;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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

        elementeV = new Image[5];
        elementeV[0] = null;

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


    public void loadMap(){
        try {
            InputStream map = getClass().getResourceAsStream("src/main/java/ym/lustigesFortsGame/txtmap/map.txt");
            BufferedReader skr = new BufferedReader(new InputStreamReader(map));


            int countX = 0;
            int countY = 0;

            while (countY < getMaxYgraphic() && countX < getMaxXgraphic()) {

                String line = skr.readLine();
                while (countX < getMaxXgraphic()){

                    String numberString[] = line.split(" ");
                    int number = Integer.parseInt(numberString[countX]);
                    inputMap[countX][countY] = number;
                    countX = countX+1;

                    if(countX == getMaxXgraphic()){
                        countX = 0;
                        countY += 1;
                    }


                }
                skr.close();
            }

        }catch (Exception e){

        }
    }


    public void loadOverlay(){
        try {
            InputStream overlay = getClass().getResourceAsStream("src/main/java/ym/lustigesFortsGame/txtmap/Overlay.txt");
            BufferedReader skr = new BufferedReader(new InputStreamReader(overlay));
            int countX = 0;
            int countY = 0;
            while (countY < getMaxYgraphic() && countX < getMaxXgraphic()) {
                String line = skr.readLine();

                while (countX < getMaxXgraphic()){

                    String numberString[] = line.split(" ");
                    int number = Integer.parseInt(numberString[countX]);
                    inputOverlay[countX][countY] = number;
                    countX = countX+1;

                    if(countX == getMaxXgraphic()){
                        countX = 0;
                        countY += 1;
                    }
                }
            }
            skr.close();
        }catch (Exception e){
        }

    }


}
