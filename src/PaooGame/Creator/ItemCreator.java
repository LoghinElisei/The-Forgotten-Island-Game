package PaooGame.Creator;

import PaooGame.Entity.Character;
import PaooGame.Entity.Entity;
import PaooGame.RefLinks;


public abstract class ItemCreator {

    public Character getItem(ItemType type, RefLinks refLink, int x, int y) {
        Character entity = createItem(type, refLink, x, y);
        return entity;
    }

    protected abstract Character createItem(ItemType type, RefLinks refLin, int x, int y);
}
