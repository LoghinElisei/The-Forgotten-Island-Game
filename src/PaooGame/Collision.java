package PaooGame;

import PaooGame.GameWindow.GameWindow;
import PaooGame.Items.Character;
import PaooGame.Tiles.Tile;



public class Collision {
    private GameWindow wnd;
    private RefLinks refLink;


    private boolean debug = false;

    public Collision(RefLinks refLink ,GameWindow wnd)
    {
        this.wnd = wnd;
        this.refLink = refLink;
    }

    public void checkTile(Character item)
    {
        int characterLeftX = item.GetX() + item.bounds.x;
        int characterRightX = item.GetX()  + item.bounds.x + item.bounds.width;
        int characterTopY = item.GetY() + item.bounds.y;
        int characterBottomY = item.GetY()  + item.bounds.y + item.bounds.height;



        System.out.println("x = " + item.GetX());
        System.out.println("y = " + item.GetY());
        System.out.println(characterLeftX);
        System.out.println(characterRightX);
        System.out.println(characterTopY);
        System.out.println(characterBottomY);



        int tileSize = Tile.TILE_WIDTH;

        int characterLeftCol = (int)(characterLeftX / (float)tileSize);
        int characterRightCol = (int)(characterRightX / (float)tileSize);
        int characterTopRow = (int)(characterTopY / (float)tileSize);
        int characterBottomRow = (int)(characterBottomY / (float)tileSize);

        Tile tileNum1, tileNum2;

        switch (item.getDirection())
        {
            case "up":
                characterTopRow = (characterTopY - item.GetSpeed()) / tileSize;
                tileNum1 = refLink.GetMap().GetCollisionTile(characterLeftCol, characterTopRow);
                tileNum2 = refLink.GetMap().GetCollisionTile(characterRightCol, characterTopRow);
                System.out.println("(" + characterLeftCol + ", " + characterTopRow + ")");
                System.out.println("(" + characterRightCol + ", " + characterTopRow + ")");
                System.out.println("tile1: " + tileNum1);
                System.out.println("tile2: " + tileNum2);
                if (!debug && (tileNum1.IsSolid() || tileNum2.IsSolid())) {
                    System.out.println(item.getDirection() + " is Solid");
                    item.setCollisionOn(true);
                }
                break;
            case "down":
                characterBottomRow = (characterBottomY + item.GetSpeed()) / tileSize;
                tileNum1 = refLink.GetMap().GetCollisionTile(characterLeftCol, characterBottomRow);
                tileNum2 = refLink.GetMap().GetCollisionTile(characterRightCol, characterBottomRow);
                System.out.println("(" + characterLeftCol + ", " + characterBottomRow + ")");
                System.out.println("(" + characterRightCol + ", " + characterBottomRow + ")");

                System.out.println("tile1: " + tileNum1);
                System.out.println("tile2: " + tileNum2);
                if (!debug && (tileNum1.IsSolid() || tileNum2.IsSolid())) {
                    System.out.println(item.getDirection() + " is Solid");
                    item.setCollisionOn(true);
                }
                break;
            case "left":
                characterLeftCol = (characterLeftX - item.GetSpeed()) / tileSize;
                tileNum1 = refLink.GetMap().GetCollisionTile(characterLeftCol, characterTopRow);
                tileNum2 = refLink.GetMap().GetCollisionTile(characterLeftCol, characterBottomRow);
                System.out.println("(" + characterLeftCol + ", " + characterTopRow + ")");
                System.out.println("(" + characterLeftCol + ", " + characterBottomRow + ")");
                System.out.println("tile1: " + tileNum1);
                System.out.println("tile2: " + tileNum2);
                if (!debug && (tileNum1.IsSolid() || tileNum2.IsSolid())) {
                    System.out.println(item.getDirection() + " is Solid");
                    item.setCollisionOn(true);
                }
                break;
            case "right":
                characterRightCol = (characterRightX + item.GetSpeed()) / tileSize;
                tileNum1 = refLink.GetMap().GetCollisionTile(characterRightCol, characterTopRow);
                tileNum2 = refLink.GetMap().GetCollisionTile(characterRightCol, characterBottomRow);
                System.out.println("(" + characterRightCol + ", " + characterTopRow + ")");
                System.out.println("(" + characterRightCol + ", " + characterBottomRow + ")");
                System.out.println("tile1: " + tileNum1);
                System.out.println("tile2: " + tileNum2);
                if (!debug && (tileNum1.IsSolid() || tileNum2.IsSolid())) {
                    System.out.println(item.getDirection() + " is Solid");
                    item.setCollisionOn(true);
                }
        }
    }
}
