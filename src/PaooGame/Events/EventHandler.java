package PaooGame.Events;

import PaooGame.Entity.Character;
import PaooGame.Maps.Map;
import PaooGame.Maps.Map1;
import PaooGame.Maps.Map2;
import PaooGame.Maps.Map3;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class EventHandler {
    private Rectangle eventRect;
    private int eventDefaultRectX, eventDefaultRectY;
    private Character entity;
    private RefLinks refLink;

    public EventHandler(Character entity, RefLinks refLink){
        eventRect = new Rectangle();

        eventRect.x = 16 * 4;
        eventRect.y = 16 * 4;
        eventRect.width = 16 * 4;
        eventRect.height = 16 * 4;
        eventDefaultRectX = eventRect.x;
        eventDefaultRectY = eventRect.y;

        this.entity = entity;
        this.refLink = refLink;
    }


    public void checkEvent(){
        if (hit(37, 17, "any") || hit(37, 16, "any")) teleportMap(2, 7, 15);
        if (hit(47, 15, "any") || hit(47, 16, "any")) teleportMap(3, 7, 15);
    }

    private void setDefaultEventRect() {
        eventRect.x = eventDefaultRectX;
        eventRect.y = eventDefaultRectY;
    }

    private boolean hit(int eventCol, int eventRow, String reqDirection) {
        boolean hit = false;

        entity.bounds.x = entity.bounds.x + entity.GetX();
        entity.bounds.y = entity.bounds.y + entity.GetY();
        eventRect.x = eventRect.x + eventCol * Tile.TILE_WIDTH;
        eventRect.y = eventRect.y + eventRow * Tile.TILE_HEIGHT;
        Graphics2D g = refLink.GetGame().getGraphics();

        if (entity.bounds.intersects(eventRect)) {
            if (entity.getDirection().equals(reqDirection) || reqDirection.equals("any")){
                hit = true;
            }
        }
        entity.SetDefaultMode();
        setDefaultEventRect();
        return hit;
    }

    private void teleportMap(int mapNumber, int col, int row){
        Map map;

        switch(mapNumber) {
            case 1:
                map = new Map1(refLink);
                PlayState.setMap(map);
                refLink.SetMap(map);
                break;
            case 2:
                map = new Map2(refLink);
                PlayState.setMap(map);
                refLink.SetMap(map);
                break;
            case 3:
                map = new Map3(refLink);
                PlayState.setMap(map);
                refLink.SetMap(map);
        }


        entity.SetX(Tile.TILE_WIDTH * col);
        entity.SetY(Tile.TILE_HEIGHT * row);

    }
}
