package PaooGame.Creator.EnemyCreator;

import PaooGame.Creator.ItemCreator;
import PaooGame.Creator.ItemType;
import PaooGame.Items.Item;
import PaooGame.Items.Ogre;
import PaooGame.RefLinks;

public class EnemyItemCreator extends ItemCreator {
    @Override
    protected Item createItem(ItemType type, RefLinks refLink, float x, float y)  {
        switch (type)
        {
            case OGRE:
                return new Ogre(refLink, x, y);
        }
        return null;
    }
}
