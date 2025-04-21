package PaooGame.Creator.HeroCreator;

import PaooGame.Creator.ItemCreator;
import PaooGame.Creator.ItemType;
import PaooGame.Items.Hero;
import PaooGame.Items.Item;
import PaooGame.RefLinks;

public class HeroItemCreator extends ItemCreator {
    @Override
    protected Item createItem(ItemType type, RefLinks refLink, int x, int y) {
        return new Hero(refLink, x, y);
    }
}
