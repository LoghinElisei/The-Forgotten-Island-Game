package PaooGame.Tiles;
import PaooGame.Graphics.Assets;
public class YellowTreeTile extends  Tile{
    public YellowTreeTile(int id)
    {
        super(Assets.yellowTree, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
