package Game.Creator.EnemyCreator;

import Game.Creator.EntityCreator;
import Game.Creator.EntityType;
import Game.Entity.Blaze;
import Game.Entity.Character;
import Game.Entity.Chupacabra;
import Game.Entity.Orc;
import Game.RefLinks;
import Game.Tiles.Tile;

public class EnemyCreator extends EntityCreator {
    @Override
    protected Character createItem(EntityType type, RefLinks refLink, int x, int y)  {
        switch (type)
        {
            case ORC:
                return new Orc(refLink, x * Tile.TILE_WIDTH, y * Tile.TILE_WIDTH);
            case BLAZE:
                return new Blaze(refLink, x * Tile.TILE_WIDTH, y * Tile.TILE_WIDTH);
            case CHUPACABRA:
                return new Chupacabra(refLink, x * Tile.TILE_WIDTH, y * Tile.TILE_WIDTH);
        }
        return null;
    }
}
