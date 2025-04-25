package PaooGame.Maps;

import PaooGame.Camera.Camera;
import PaooGame.Items.ItemPlacer;
import PaooGame.Items.SuperObject;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class Map {
    protected RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    protected int width;          /*!< Latimea hartii in numar de dale.*/
    protected int height;         /*!< Inaltimea hartii in numar de dale.*/
    protected int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    protected int [][] collision;
    public static Camera camera = new Camera(300,300,1408,1056);
    public static ItemPlacer itemPlacer;
    public SuperObject items[];



    public Map(RefLinks refLink)
    {
        /// Retine referinta "shortcut".
        this.refLink = refLink;
        itemPlacer = new ItemPlacer(refLink);
        ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.

    }

    public abstract void Update();
    public void Draw(Graphics2D g2d)
    {
        camera.apply(g2d);
        //Determină limitele vizibile pe baza poziției camerei și dimensiunii dalelor
        int startX = 0;
        int startY = 0;
        int endX = Math.min(width, (int) (camera.getBounds().x + camera.getBounds().width) / Tile.TILE_WIDTH + 1);
        int endY = Math.min(height, (int) (camera.getBounds().y + camera.getBounds().height) / Tile.TILE_HEIGHT + 1);

        // Parcurge doar dalele vizibile
        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                // Desenează dalele de bază
                GetTile(x, y).Draw(g2d, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);

                // Dacă există o dală de coliziune, o desenăm de asemenea
                if (collision[x][y] != 0) {
                    GetCollisionTile(x, y).Draw(g2d, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
                }

            }
        }
        g2d.setTransform(new AffineTransform());
    }


    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.grassTile;
        }
        return t;
    }
    public Tile GetCollisionTile(int x,int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[collision[x][y]];

        if(t == null)
        {
            return Tile.grassTile;
        }
        return t;
    }

    protected abstract void CollisionMap();
    protected abstract void  ThematicMap();

    public Map nextMap(int lvl){
        if (lvl == 2)
        {
            return new Map2(refLink);
        }
        return new Map3(refLink);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
