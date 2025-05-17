package PaooGame.Entity;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Blaze extends Character {
    private BufferedImage image;

    public Blaze(RefLinks refLink, int x, int y)
    {
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

        normalBounds.x = 50;
        normalBounds.y = 45;
        normalBounds.width = 32;
        normalBounds.height = 32 * 2;

        defaultBoundsX = normalBounds.x;
        defaultBoundsY = normalBounds.y;
        speed = 2;
    }


    @Override
    public void Draw(Graphics2D g) {
        State playState = refLink.GetGame().playState;
        int screenX = x - playState.getHero().x + playState.getHero().screenX;
        int screenY = y - playState.getHero().y + playState.getHero().screenY;

        if (x + Tile.TILE_WIDTH > playState.getHero().x - playState.getHero().screenX &&
                x - Tile.TILE_WIDTH < playState.getHero().x + playState.getHero().screenX &&
                y + Tile.TILE_WIDTH > playState.getHero().y - playState.getHero().screenY &&
                y - Tile.TILE_WIDTH < playState.getHero().y + playState.getHero().screenY) {

            switch (direction) {
                case "up":
                    switch (spriteNum) {
                        case 1: image = Assets.orcUp1; break;
                        case 2: image = Assets.orcUp2; break;
                        case 3: image = Assets.orcUp3;
                    }
                    break;
                case "down":
                    switch (spriteNum) {
                        case 1: image = Assets.orcDown1; break;
                        case 2: image = Assets.orcDown2; break;
                        case 3: image = Assets.orcDown3;
                    }
                    break;
                case "left":
                    switch (spriteNum) {
                        case 1: image = Assets.orcLeft1; break;
                        case 2: image = Assets.orcLeft2; break;
                        case 3: image = Assets.orcLeft3;
                    }
                    break;
                case "right":
                    switch (spriteNum) {
                        case 1: image = Assets.orcRight1; break;
                        case 2: image = Assets.orcRight2; break;
                        case 3: image = Assets.orcRight3;
                    }
            }

            g.drawImage(image, screenX, screenY, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);


            g.setColor(Color.BLUE);
            g.fillRect(screenX + bounds.x, screenY + bounds.y, bounds.width, bounds.height);
        }
    }

    @Override
    protected void setAction(){
        if (onPath) searchPath(goalCol, goalRow);
        else searchPath(startCol, startRow);
    }
}
