package Game.Items;


import Game.Graphics.Assets;
import Game.Tiles.Tile;

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
