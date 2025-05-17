package PaooGame.Items;

import PaooGame.Creator.EnemyCreator.EnemyItemCreator;
import PaooGame.Creator.ItemCreator;
import PaooGame.Creator.ItemType;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

public class ItemPlacer {

    private RefLinks refLink;
    private ItemCreator enemyCreator = new EnemyItemCreator();
    public ItemPlacer(RefLinks refLink)
    {
        this.refLink = refLink;
    }

    public void addObject(int mapNumber, Map map){

        switch (mapNumber)
        {
            case 1:
                map.items[0] = new Key();
                map.items[0].worldX = 22 * Tile.TILE_WIDTH;
                map.items[0].worldY = 8 * Tile.TILE_HEIGHT;

                map.items[11] = new Key();
                map.items[11].worldX = 24 * Tile.TILE_WIDTH;
                map.items[11].worldY = 25 * Tile.TILE_HEIGHT;

                map.items[1] = new Coin();
                map.items[1].worldX = 7 * Tile.TILE_WIDTH;
                map.items[1].worldY = 10 * Tile.TILE_HEIGHT;

                map.items[2] = new Coin();
                map.items[2].worldX = 14 * Tile.TILE_WIDTH;
                map.items[2].worldY = 7 * Tile.TILE_HEIGHT;

                map.items[3] = new Coin();
                map.items[3].worldX = 25 * Tile.TILE_WIDTH;
                map.items[3].worldY = 7 * Tile.TILE_HEIGHT;

                map.items[4] = new Coin();
                map.items[4].worldX = 33 * Tile.TILE_WIDTH;
                map.items[4].worldY = 7 * Tile.TILE_HEIGHT;

                map.items[5] = new Coin();
                map.items[5].worldX = 17 * Tile.TILE_WIDTH;
                map.items[5].worldY = 13 * Tile.TILE_HEIGHT;

                map.items[6] = new Coin();
                map.items[6].worldX = 25 * Tile.TILE_WIDTH;
                map.items[6].worldY = 13 * Tile.TILE_HEIGHT;

                map.items[7] = new Coin();
                map.items[7].worldX = 30 * Tile.TILE_WIDTH;
                map.items[7].worldY = 19 * Tile.TILE_HEIGHT;

                map.items[8] = new Coin();
                map.items[8].worldX = 24 * Tile.TILE_WIDTH;
                map.items[8].worldY = 22 * Tile.TILE_HEIGHT;

                map.items[9] = new Coin();
                map.items[9].worldX = 35 * Tile.TILE_WIDTH;
                map.items[9].worldY = 24 * Tile.TILE_HEIGHT;

                map.items[10] = new Coin();
                map.items[10].worldX = 9 * Tile.TILE_WIDTH;
                map.items[10].worldY = 25 * Tile.TILE_HEIGHT;
                break;
            case 2:
                map.items[0] = new Key();
                map.items[0].worldX = 31 * Tile.TILE_WIDTH;
                map.items[0].worldY = 7 * Tile.TILE_HEIGHT;

                map.items[15] = new Key();
                map.items[15].worldX = 31 * Tile.TILE_WIDTH;
                map.items[15].worldY = 21 * Tile.TILE_HEIGHT;

                map.items[1] = new Coin();
                map.items[1].worldX = 39 * Tile.TILE_WIDTH;
                map.items[1].worldY = 7 * Tile.TILE_HEIGHT;

                map.items[2] = new Coin();
                map.items[2].worldX = 46 * Tile.TILE_WIDTH;
                map.items[2].worldY = 7 * Tile.TILE_HEIGHT;

                map.items[3] = new Coin();
                map.items[3].worldX = 7 * Tile.TILE_WIDTH;
                map.items[3].worldY = 7 * Tile.TILE_HEIGHT;

                map.items[4] = new Coin();
                map.items[4].worldX = 22 * Tile.TILE_WIDTH;
                map.items[4].worldY = 8 * Tile.TILE_HEIGHT;

                map.items[5] = new Coin();
                map.items[5].worldX = 31 * Tile.TILE_WIDTH;
                map.items[5].worldY = 13 * Tile.TILE_HEIGHT;

                map.items[6] = new Coin();
                map.items[6].worldX = 46 * Tile.TILE_WIDTH;
                map.items[6].worldY = 13 * Tile.TILE_HEIGHT;

                map.items[7] = new Coin();
                map.items[7].worldX = 15 * Tile.TILE_WIDTH;
                map.items[7].worldY = 15 * Tile.TILE_HEIGHT;

                map.items[8] = new Coin();
                map.items[8].worldX = 24 * Tile.TILE_WIDTH;
                map.items[8].worldY = 16 * Tile.TILE_HEIGHT;

                map.items[9] = new Coin();
                map.items[9].worldX = 21 * Tile.TILE_WIDTH;
                map.items[9].worldY = 18 * Tile.TILE_HEIGHT;

                map.items[10] = new Coin();
                map.items[10].worldX = 25 * Tile.TILE_WIDTH;
                map.items[10].worldY = 19 * Tile.TILE_HEIGHT;

                map.items[11] = new Coin();
                map.items[11].worldX = 41 * Tile.TILE_WIDTH;
                map.items[11].worldY = 20 * Tile.TILE_HEIGHT;

                map.items[12] = new Coin();
                map.items[12].worldX = 19 * Tile.TILE_WIDTH;
                map.items[12].worldY = 24 * Tile.TILE_HEIGHT;

                map.items[13] = new Coin();
                map.items[13].worldX = 7 * Tile.TILE_WIDTH;
                map.items[13].worldY = 25 * Tile.TILE_HEIGHT;

                map.items[14] = new Coin();
                map.items[14].worldX = 44 * Tile.TILE_WIDTH;
                map.items[14].worldY = 25 * Tile.TILE_HEIGHT;
                break;
            case 3:
                map.items[0] = new Coin();
                map.items[0].worldX = 13 * Tile.TILE_WIDTH;
                map.items[0].worldY = 7 * Tile.TILE_HEIGHT;

                map.items[1] = new Coin();
                map.items[1].worldX = 33 * Tile.TILE_WIDTH;
                map.items[1].worldY = 7 * Tile.TILE_HEIGHT;

                map.items[2] = new Coin();
                map.items[2].worldX = 56 * Tile.TILE_WIDTH;
                map.items[2].worldY = 7 * Tile.TILE_HEIGHT;

                map.items[3] = new Coin();
                map.items[3].worldX = 25 * Tile.TILE_WIDTH;
                map.items[3].worldY = 8 * Tile.TILE_HEIGHT;

                map.items[4] = new Coin();
                map.items[4].worldX = 52 * Tile.TILE_WIDTH;
                map.items[4].worldY = 10 * Tile.TILE_HEIGHT;

                map.items[5] = new Coin();
                map.items[5].worldX = 30 * Tile.TILE_WIDTH;
                map.items[5].worldY = 11 * Tile.TILE_HEIGHT;


                map.items[6] = new Coin();
                map.items[6].worldX = 20 * Tile.TILE_WIDTH;
                map.items[6].worldY = 13 * Tile.TILE_HEIGHT;

                map.items[7] = new Coin();
                map.items[7].worldX = 36 * Tile.TILE_WIDTH;
                map.items[7].worldY = 13 * Tile.TILE_HEIGHT;

                map.items[8] = new Coin();
                map.items[8].worldX = 46 * Tile.TILE_WIDTH;
                map.items[8].worldY = 14 * Tile.TILE_HEIGHT;

                map.items[9] = new Coin();
                map.items[9].worldX = 25 * Tile.TILE_WIDTH;
                map.items[9].worldY = 16 * Tile.TILE_HEIGHT;

                map.items[10] = new Coin();
                map.items[10].worldX = 40 * Tile.TILE_WIDTH;
                map.items[10].worldY = 17 * Tile.TILE_HEIGHT;
                int i = 10;
                map.items[++i] = new Coin();
                map.items[i].worldX = 51 * Tile.TILE_WIDTH;
                map.items[i].worldY = 18 * Tile.TILE_HEIGHT;

                map.items[++i] = new Coin();
                map.items[i].worldX = 33 * Tile.TILE_WIDTH;
                map.items[i].worldY = 20 * Tile.TILE_HEIGHT;

                map.items[++i] = new Coin();
                map.items[i].worldX = 15 * Tile.TILE_WIDTH;
                map.items[i].worldY = 22 * Tile.TILE_HEIGHT;

                map.items[++i] = new Coin();
                map.items[i].worldX = 15 * Tile.TILE_WIDTH;
                map.items[i].worldY = 22 * Tile.TILE_HEIGHT;

                map.items[++i] = new Coin();
                map.items[i].worldX = 42 * Tile.TILE_WIDTH;
                map.items[i].worldY = 22 * Tile.TILE_HEIGHT;

                map.items[++i] = new Coin();
                map.items[i].worldX = 51 * Tile.TILE_WIDTH;
                map.items[i].worldY = 22 * Tile.TILE_HEIGHT;


                map.items[++i] = new Coin();
                map.items[i].worldX = 26 * Tile.TILE_WIDTH;
                map.items[i].worldY = 24 * Tile.TILE_HEIGHT;

                map.items[++i] = new Coin();
                map.items[i].worldX = 7 * Tile.TILE_WIDTH;
                map.items[i].worldY = 25 * Tile.TILE_HEIGHT;


                map.items[++i] = new Coin();
                map.items[i].worldX = 56 * Tile.TILE_WIDTH;
                map.items[i].worldY = 25 * Tile.TILE_HEIGHT;

                map.items[++i] = new Key();
                map.items[i].worldX = 43 * Tile.TILE_WIDTH;
                map.items[i].worldY = 8 * Tile.TILE_HEIGHT;

                map.items[++i] = new Key();
                map.items[i].worldX = 43 * Tile.TILE_WIDTH;
                map.items[i].worldY = 24 * Tile.TILE_HEIGHT;

                break;
        }
    }

    public void setEnemies(int mapNumber, Map map){
        switch (mapNumber){
            case 1:
                map.monsters[0] = enemyCreator.getItem(ItemType.ORC, refLink, 36 * Tile.TILE_WIDTH, 12 * Tile.TILE_HEIGHT);
                for (int i = 0; i < map.monsters.length; ++i) {
                    if (map.monsters[i] != null) {
                    }
                }
                break;
            case 2:
                map.monsters[0] = enemyCreator.getItem(ItemType.BLAZE, refLink, 20 * Tile.TILE_WIDTH, 21 * Tile.TILE_HEIGHT);
                for (int i = 0; i < map.monsters.length; ++i) {
                    if (map.monsters[i] != null) {
                        map.monsters[i].setOnPath(true); // Inamicii se vor misca de la o locatie la alta, indiferent de actiunile jucatorul
                    }
                }
                map.monsters[0].setPath(20, 21, 30, 10);
                break;
            case 3:
                map.monsters[0] = enemyCreator.getItem(ItemType.CHUPACABRA, refLink, 25 * Tile.TILE_WIDTH, 21 * Tile.TILE_HEIGHT);
                for (int i = 0; i < map.monsters.length; ++i)
                    if (map.monsters[i] != null) {
                        map.monsters[i].setOnPath(true); // Inamicii se vor misca de la o locatie la alta, indiferent de actiunile jucatorul
                    }
                map.monsters[0].setPath(25, 21, 40, 21);
                break;
        }
    }
}
