package PaooGame.Creator.EnemyCreator;

import PaooGame.Creator.ItemCreator;
import PaooGame.Creator.ItemType;
import PaooGame.Entity.Character;
import PaooGame.Entity.Orc;
import PaooGame.RefLinks;

public class EnemyItemCreator extends ItemCreator {
    @Override
    protected Character createItem(ItemType type, RefLinks refLink, int x, int y)  {
        switch (type)
        {
            case ORC:
                return new Orc(refLink, x, y);
        }
        return null;
    }
}
