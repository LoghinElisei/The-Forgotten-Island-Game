package Game.Tiles;
import Game.Graphics.Assets;
public class Tree2Tile extends  Tile{
    public Tree2Tile(int id)
    {
        super(Assets.tree2, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
