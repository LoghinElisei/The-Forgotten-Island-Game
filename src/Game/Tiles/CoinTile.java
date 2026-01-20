package Game.Tiles;
import Game.Graphics.Assets;
public class CoinTile extends  Tile{
    public CoinTile(int id)
    {
        super(Assets.coin, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
