package PaooGame.Entity;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Orc extends Character {
    private BufferedImage image;
    private int actionLockCounter = 0;

    public Orc(RefLinks refLink, int x, int y)
    {
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

        normalBounds.x = 50;
        normalBounds.y = 80;
        normalBounds.width = 32;
        normalBounds.height = 32;
        speed = 2;

    }

    @Override
    public void Update() {
        setAction();
        ///Implicit monstrul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;

        collisionOn = false;
        refLink.GetGame().getCollisionChecker().checkTile(this);

        if (!collisionOn)
        {
            switch (direction)
            {
                case "up": yMove = -speed; break;
                case "down": yMove = speed; break;
                case "left": xMove = -speed; break;
                case "right": xMove = speed;
            }
        }
        ///Actualizeaza pozitia
        Move();
        ///Actualizeaza imaginea
        spriteCounter++;
        if (spriteCounter > 10)
        {
            changeSpriteNum();
            spriteCounter = 0;
        }
    }

    public void Draw(Graphics2D g, PlayState playState) {
        BufferedImage image = null;
        int screenX = x - playState.getHero().GetX() + playState.getHero().screenX;
        int screenY = y - playState.getHero().GetY() + playState.getHero().screenY;

        if (x + Tile.TILE_WIDTH > playState.getHero().GetX() - playState.getHero().screenX &&
                x - Tile.TILE_WIDTH < playState.getHero().GetX() + playState.getHero().screenX &&
                y + Tile.TILE_WIDTH > playState.getHero().GetY() - playState.getHero().screenY &&
                y - Tile.TILE_WIDTH < playState.getHero().GetY() + playState.getHero().screenY) {

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
//            g2.setColor(Color.RED);
//            g2.fillRect(screenX, screenY, boundsDefaultX, boundsDefaultY);
        }
    }

    @Override
    public void Draw(Graphics2D g2d) {}

    private void setAction(){
        actionLockCounter++;
        if (actionLockCounter == 120) {
            Random random = new Random();
            int randomNumber = random.nextInt(100)  + 1; // pick a number between 1 and 100
            if (randomNumber <= 25) {
                direction = "up";
            } else if (randomNumber > 25 && randomNumber <= 50) {
                direction = "down";
            } else if (randomNumber > 50 && randomNumber <= 75) {
                direction = "left";
            } else {
                direction = "right";
            }
            actionLockCounter = 0;
        }

    }
}
