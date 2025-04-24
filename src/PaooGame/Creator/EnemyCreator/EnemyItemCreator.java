package PaooGame.Creator.EnemyCreator;

import PaooGame.Creator.ItemCreator;
import PaooGame.Creator.ItemType;
import PaooGame.Items.Item;
import PaooGame.Items.Orc;
import PaooGame.RefLinks;

public class EnemyItemCreator extends ItemCreator {
    @Override
    protected Item createItem(ItemType type, RefLinks refLink, int x, int y)  {
        switch (type)
        {
            case ORC:
                return new Orc(refLink, x, y);
        }
        return null;
    }
}
