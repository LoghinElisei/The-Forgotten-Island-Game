package PaooGame.Maps;

import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */

public class Map2 extends Map
{
    public Map2(RefLinks refLink)
    {
        /// Retine referinta "shortcut".
        super(refLink);
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
        ///Se stabileste latimea hartii in numar de dale.
        width = 44;
        ///Se stabileste inaltimea hartii in numar de dale
        height = 33;
        ///Se construieste matricea de coduri de dale
        ThematicMap();
        CollisionMap();
    }
    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    @Override
    public  void Update() {
    }

    /*! \fn private int MiddleEastMap(int x ,int y)
        \brief O harta incarcata static.

        \param x linia pe care se afla codul dalei de interes.
        \param y coloana pe care se afla codul dalei de interes.
     */
    @Override
    protected void ThematicMap() {
        String path = "res/maps/thematic/map1.txt";

        int [][] map = new int[height][width];
        tiles=new int[width][height];
        String line;
        int row = 0;
        try {
//            System.out.println("Trying to open file with FileReader...");
            FileReader fr = new FileReader(path);
//            System.out.println("FileReader opened successfully.");
            BufferedReader reader = new BufferedReader(fr);

            while((line = reader.readLine()) != null && row <height){
                line = line.trim(); //elimina spatiile de la inceput si sfarsit
                if(line.isEmpty()) continue;

                String [] element = line.split("\\s+");
                for(int i=0;i<width;i++)
                {
                    map[row][i] = Integer.parseInt(element[i]);
                }

                row++;
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    tiles[j][i] = map[i][j];
                }
            }

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Text file ThematicMap couldn't be opened");
        }

    }
    @Override
    protected void CollisionMap()
    {

        String path = "res/maps/collision/map1.txt";

        int [][] map = new int[height][width];
        collision=new int[width][height];
        String line;
        int row = 0;
        try {
//            System.out.println("Trying to open file with FileReader...");
            FileReader fr = new FileReader(path);
//            System.out.println("FileReader opened successfully.");
            BufferedReader reader = new BufferedReader(fr);


            while((line = reader.readLine()) != null && row < height){
                line = line.trim(); //elimina spatiile de la inceput si sfarsit
                if(line.isEmpty()) continue;

                String [] element = line.split("\\s+");
                for(int i=0;i<width;i++)
                {
                    map[row][i] = Integer.parseInt(element[i]);
                }

                row++;
            }
            //facem transpusa matricii
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    collision[j][i] = map[i][j];
                }}

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Text file ThematicMap couldn't be opened");
        }

    }

}