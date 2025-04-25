package PaooGame.Creator;

import PaooGame.Entity.Entity;
import PaooGame.RefLinks;


public abstract class ItemCreator {

    public Entity getItem(ItemType type, RefLinks refLink, int x, int y) {
        Entity entity = createItem(type, refLink, x, y);
        return entity;
    }

    protected abstract Entity createItem(ItemType type, RefLinks refLin, int x, int y);
}
