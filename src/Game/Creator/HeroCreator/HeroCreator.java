package Game.Creator.HeroCreator;

import Game.Creator.EntityCreator;
import Game.Creator.EntityType;
import Game.Entity.Character;
import Game.Entity.Hero;
import Game.RefLinks;

public class HeroCreator extends EntityCreator {
    @Override
    protected Character createItem(EntityType type, RefLinks refLink, int x, int y) {
        return new Hero(refLink, x, y);
    }
}
