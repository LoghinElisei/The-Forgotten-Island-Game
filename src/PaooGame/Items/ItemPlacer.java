package PaooGame.Items;

import PaooGame.Entity.Orc;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

public class ItemPlacer {

    private RefLinks refLink;

    public ItemPlacer(RefLinks refLink)
    {
        this.refLink = refLink;
    }

    public void addObject(int mapNumber){

        switch (mapNumber)
        {
            case 1:
                refLink.GetMap().items[0] = new Key();
                refLink.GetMap().items[0].worldX = 22 * Tile.TILE_WIDTH;
                refLink.GetMap().items[0].worldY = 8 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[11] = new Key();
                refLink.GetMap().items[11].worldX = 24 * Tile.TILE_WIDTH;
                refLink.GetMap().items[11].worldY = 25 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[1] = new Coin();
                refLink.GetMap().items[1].worldX = 7 * Tile.TILE_WIDTH;
                refLink.GetMap().items[1].worldY = 10 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[2] = new Coin();
                refLink.GetMap().items[2].worldX = 14 * Tile.TILE_WIDTH;
                refLink.GetMap().items[2].worldY = 7 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[3] = new Coin();
                refLink.GetMap().items[3].worldX = 25 * Tile.TILE_WIDTH;
                refLink.GetMap().items[3].worldY = 7 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[4] = new Coin();
                refLink.GetMap().items[4].worldX = 33 * Tile.TILE_WIDTH;
                refLink.GetMap().items[4].worldY = 7 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[5] = new Coin();
                refLink.GetMap().items[5].worldX = 17 * Tile.TILE_WIDTH;
                refLink.GetMap().items[5].worldY = 13 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[6] = new Coin();
                refLink.GetMap().items[6].worldX = 25 * Tile.TILE_WIDTH;
                refLink.GetMap().items[6].worldY = 13 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[7] = new Coin();
                refLink.GetMap().items[7].worldX = 30 * Tile.TILE_WIDTH;
                refLink.GetMap().items[7].worldY = 19 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[8] = new Coin();
                refLink.GetMap().items[8].worldX = 24 * Tile.TILE_WIDTH;
                refLink.GetMap().items[8].worldY = 22 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[9] = new Coin();
                refLink.GetMap().items[9].worldX = 35 * Tile.TILE_WIDTH;
                refLink.GetMap().items[9].worldY = 24 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[10] = new Coin();
                refLink.GetMap().items[10].worldX = 9 * Tile.TILE_WIDTH;
                refLink.GetMap().items[10].worldY = 25 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[12] = new Bridge();
                refLink.GetMap().items[12].worldX = 37 * Tile.TILE_WIDTH;
                refLink.GetMap().items[12].worldY = 17 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[13] = new Bridge();
                refLink.GetMap().items[13].worldX = 37 * Tile.TILE_WIDTH;
                refLink.GetMap().items[13].worldY = 16 * Tile.TILE_HEIGHT;
                break;
            case 2:
                refLink.GetMap().items[0] = new Key();
                refLink.GetMap().items[0].worldX = 31 * Tile.TILE_WIDTH;
                refLink.GetMap().items[0].worldY = 7 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[15] = new Key();
                refLink.GetMap().items[15].worldX = 31 * Tile.TILE_WIDTH;
                refLink.GetMap().items[15].worldY = 21 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[1] = new Coin();
                refLink.GetMap().items[1].worldX = 39 * Tile.TILE_WIDTH;
                refLink.GetMap().items[1].worldY = 7 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[2] = new Coin();
                refLink.GetMap().items[2].worldX = 46 * Tile.TILE_WIDTH;
                refLink.GetMap().items[2].worldY = 7 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[3] = new Coin();
                refLink.GetMap().items[3].worldX = 7 * Tile.TILE_WIDTH;
                refLink.GetMap().items[3].worldY = 7 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[4] = new Coin();
                refLink.GetMap().items[4].worldX = 22 * Tile.TILE_WIDTH;
                refLink.GetMap().items[4].worldY = 8 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[5] = new Coin();
                refLink.GetMap().items[5].worldX = 31 * Tile.TILE_WIDTH;
                refLink.GetMap().items[5].worldY = 13 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[6] = new Coin();
                refLink.GetMap().items[6].worldX = 46 * Tile.TILE_WIDTH;
                refLink.GetMap().items[6].worldY = 13 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[7] = new Coin();
                refLink.GetMap().items[7].worldX = 15 * Tile.TILE_WIDTH;
                refLink.GetMap().items[7].worldY = 15 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[8] = new Coin();
                refLink.GetMap().items[8].worldX = 24 * Tile.TILE_WIDTH;
                refLink.GetMap().items[8].worldY = 16 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[9] = new Coin();
                refLink.GetMap().items[9].worldX = 21 * Tile.TILE_WIDTH;
                refLink.GetMap().items[9].worldY = 18 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[10] = new Coin();
                refLink.GetMap().items[10].worldX = 25 * Tile.TILE_WIDTH;
                refLink.GetMap().items[10].worldY = 19 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[11] = new Coin();
                refLink.GetMap().items[11].worldX = 41 * Tile.TILE_WIDTH;
                refLink.GetMap().items[11].worldY = 20 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[12] = new Coin();
                refLink.GetMap().items[12].worldX = 19 * Tile.TILE_WIDTH;
                refLink.GetMap().items[12].worldY = 24 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[13] = new Coin();
                refLink.GetMap().items[13].worldX = 7 * Tile.TILE_WIDTH;
                refLink.GetMap().items[13].worldY = 25 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[14] = new Coin();
                refLink.GetMap().items[14].worldX = 44 * Tile.TILE_WIDTH;
                refLink.GetMap().items[14].worldY = 25 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[16] = new Bridge();
                refLink.GetMap().items[16].worldX = 47 * Tile.TILE_WIDTH;
                refLink.GetMap().items[16].worldY = 15 * Tile.TILE_HEIGHT;

                refLink.GetMap().items[17] = new Bridge();
                refLink.GetMap().items[17].worldX = 47 * Tile.TILE_WIDTH;
                refLink.GetMap().items[17].worldY = 16 * Tile.TILE_HEIGHT;
                break;
            case 3:

                break;
        }
    }

    public void setEnemies(int mapNumber){
        switch (mapNumber){
            case 1:
                refLink.GetMap().monsters[0] = new Orc(refLink, 21 * Tile.TILE_WIDTH, 21 * Tile.TILE_HEIGHT);
                break;
        }
    }
}
