package Game.Creator;

import Game.Entity.Character;
import Game.RefLinks;


public abstract class EntityCreator {

    public Character getItem(EntityType type, RefLinks refLink, int x, int y) {
        Character entity = createItem(type, refLink, x, y);
        return entity;
    }

    protected abstract Character createItem(EntityType type, RefLinks refLin, int x, int y);
}
