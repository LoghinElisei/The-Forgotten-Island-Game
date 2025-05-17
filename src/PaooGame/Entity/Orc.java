package PaooGame.Entity;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Orc extends Character {
    private BufferedImage image;
    private int actionLockCounter = 0;
    private boolean followPlayer = false;

    public Orc(RefLinks refLink, int x, int y)
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
    public void Update() {
        ///Implicit monstrul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        Character hero = refLink.GetGame().playState.getHero();
        int xDistance = Math.abs(x - hero.x);
        int yDistance = Math.abs(y - hero.y);
        int tileDistance = (xDistance + yDistance) / Tile.TILE_HEIGHT;
        if (tileDistance < 3 && followPlayer == false) {
            // aggressive enemy only in 50% chance
            int i = new Random().nextInt(100) + 1;
            if (i > 50) followPlayer = true;
        } else if (tileDistance > 10 && followPlayer)  followPlayer = false;
        setAction();
        collisionOn = false;
        refLink.GetGame().getCollisionChecker().checkTile(this);
        boolean contactPlayer = refLink.GetGame().getCollisionChecker().checkFromEnemyToPlayer(this);

        if (contactPlayer) {
            System.out.println("Enemy just hitted me");
        }
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

    private void setAction(){
        switch (enemyType) {
            case 0:
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
                break;
            case 1:
                if (onPath) {
                    searchPath(goalCol, goalRow);
                } else {
                    searchPath(startCol, startRow);
                }
                break;
            case 2:
                if (followPlayer == false) {
                    if (onPath) searchPath(goalCol, goalRow);
                    else searchPath(startCol, startRow);
                } else {
                    Character hero = refLink.GetGame().playState.getHero();
                    int goalCol = (hero.x + hero.bounds.x) / Tile.TILE_HEIGHT;
                    int goalRow = (hero.y + hero.bounds.y) / Tile.TILE_HEIGHT;
                    searchPath(goalCol, goalRow);
                }


                break;
        }

    }
}
