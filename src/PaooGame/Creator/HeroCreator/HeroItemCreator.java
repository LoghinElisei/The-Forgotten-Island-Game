package PaooGame.Creator.HeroCreator;

import PaooGame.Creator.ItemCreator;
import PaooGame.Creator.ItemType;
import PaooGame.Entity.Character;
import PaooGame.Entity.Hero;
import PaooGame.Entity.Entity;
import PaooGame.RefLinks;

public class HeroItemCreator extends ItemCreator {
    @Override
    protected Character createItem(ItemType type, RefLinks refLink, int x, int y) {
        return new Hero(refLink, x, y);
    }
}
