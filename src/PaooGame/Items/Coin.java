package PaooGame.Items;


import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Coin extends SuperObject {
    public Coin()
    {
        super();
        boundsDefaultX = Tile.TILE_WIDTH / 4;
        boundsDefaultY = Tile.TILE_HEIGHT / 4;
        name = "coin";
        image = Assets.coin;
    }
}
