package PaooGame.Creator;

import PaooGame.Items.Item;
import PaooGame.RefLinks;


public abstract class ItemCreator {

    public Item getItem(ItemType type, RefLinks refLink, float x, float y) {
        Item item = createItem(type, refLink, x, y);
        return item;
    }

    protected abstract Item createItem(ItemType type, RefLinks refLin, float x, float y);
}
