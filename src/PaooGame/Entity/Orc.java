package PaooGame.Entity;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Orc extends Character {
    private BufferedImage image;
    public Orc(RefLinks refLink, int x, int y)
    {
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

    }

    @Override
    public void Update() {

        spriteCounter++;
        if (spriteCounter > 10)
        {
            changeSpriteNum();
            spriteCounter = 0;
        }
    }

    @Override
    public void Draw(Graphics2D g2d) {
        switch (direction) {
            case "up":
                switch (spriteNum) {
                    case 1: image = Assets.heroUp1; break;
                    case 2: image = Assets.heroUp2; break;
                    case 3: image = Assets.heroUp3;
                }
                break;
            case "down":
                switch (spriteNum) {
                    case 1: image = Assets.heroDown1; break;
                    case 2: image = Assets.heroDown2; break;
                    case 3: image = Assets.heroDown3;
                }
                break;
            case "left":
                switch (spriteNum) {
                    case 1: image = Assets.heroLeft1; break;
                    case 2: image = Assets.heroLeft2; break;
                    case 3: image = Assets.heroLeft3;
                }
                break;
            case "right":
                switch (spriteNum) {
                    case 1: image = Assets.heroRight1; break;
                    case 2: image = Assets.heroRight2; break;
                    case 3: image = Assets.heroRight3;
                }
        }
    }
}
