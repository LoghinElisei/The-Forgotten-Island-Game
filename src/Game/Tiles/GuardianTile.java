package Game.Tiles;

import Game.Graphics.Assets;

public class GuardianTile extends Tile
{
    public GuardianTile(int id)
    {
        super(Assets.guardian, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
