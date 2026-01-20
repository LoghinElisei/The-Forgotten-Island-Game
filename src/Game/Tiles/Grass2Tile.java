package Game.Tiles;
import Game.Graphics.Assets;
public class Grass2Tile extends  Tile{
    public Grass2Tile(int id)
    {
        super(Assets.grass2, id);
    }
    @Override
    public boolean IsSolid()
    {
        return false;
    }
}
