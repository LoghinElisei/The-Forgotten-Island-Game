package PaooGame.Events;

import PaooGame.Entity.Character;
import PaooGame.Maps.Map;
import PaooGame.Maps.Map1;
import PaooGame.Maps.Map2;
import PaooGame.Maps.Map3;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;
import PaooGame.States.State;
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


    public void checkEvent(String currentMap){
        if (hit(37, 17, "any", "Map1", currentMap) || hit(37, 16, "any", "Map1", currentMap)) teleportMap(2, 7, 15);
        if (hit(47, 15, "any", "Map2", currentMap) || hit(47, 16, "any", "Map2", currentMap)) teleportMap(3, 7, 15);
        if (hit(57, 16, "any", "Map3", currentMap)) finishGame();

    }

    private void setDefaultEventRect() {
        eventRect.x = eventDefaultRectX;
        eventRect.y = eventDefaultRectY;
    }

    private boolean hit(int eventCol, int eventRow, String reqDirection, String reqMap, String currentMap) {
        boolean hit = false;

        entity.bounds.x = entity.bounds.x + entity.GetX();
        entity.bounds.y = entity.bounds.y + entity.GetY();
        eventRect.x = eventRect.x + eventCol * Tile.TILE_WIDTH;
        eventRect.y = eventRect.y + eventRow * Tile.TILE_HEIGHT;
        Graphics2D g = refLink.GetGame().getGraphics();

        if (entity.bounds.intersects(eventRect)) {
            if ((entity.getDirection().equals(reqDirection) || reqDirection.equals("any")) && currentMap.equals(reqMap)){
                hit = true;
            }
        }
        entity.SetDefaultMode();
        setDefaultEventRect();
        return hit;
    }
    private void finishGame(){
        if (refLink.GetGame().playState.getHero().getKeys() == 2) {
            refLink.GetGame().playState.getHero().setKeys(0);
            refLink.setState(refLink.GetGame().gameCompletedState);
            State.SetState(refLink.GetGame().gameCompletedState);
        }
    }
    private void teleportMap(int mapNumber, int col, int row){
        Map map;
        if (refLink.GetGame().playState.getHero().getKeys() == 1) {
            switch (mapNumber) {
                case 2:
                    refLink.GetGame().playState.getHero().setKeys(0);
                    map = new Map2(refLink);
                    PlayState.setMap(map);
                    refLink.SetMap(map);
                    entity.SetX(Tile.TILE_WIDTH * col);
                    entity.SetY(Tile.TILE_HEIGHT * row);
                    break;
                case 3:
                    refLink.GetGame().playState.getHero().setKeys(0);
                    map = new Map3(refLink);
                    PlayState.setMap(map);
                    refLink.SetMap(map);
                    entity.SetX(Tile.TILE_WIDTH * col);
                    entity.SetY(Tile.TILE_HEIGHT * row);
            }
        }




    }
}
