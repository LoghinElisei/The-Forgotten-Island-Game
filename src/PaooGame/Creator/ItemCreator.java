package PaooGame.Creator;

import PaooGame.Items.Item;
import PaooGame.RefLinks;


public abstract class ItemCreator {

    public Item getItem(ItemType type, RefLinks refLink, int x, int y) {
        Item item = createItem(type, refLink, x, y);
        return item;
    }

    protected abstract Item createItem(ItemType type, RefLinks refLin, int x, int y);
}
