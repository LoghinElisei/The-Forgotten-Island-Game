package PaooGame.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.Events.EventHandler;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private int keys = 0;
    private int coins = 0;
    private EventHandler eventHandler;
    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, int x, int y)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
            ///Seteaza imaginea de start a eroului
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 35;
        normalBounds.y = 60;
        normalBounds.width = 25;
        normalBounds.height = 25;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        defaultBoundsX = normalBounds.x;
        defaultBoundsY = normalBounds.y;
        eventHandler = new EventHandler(this, refLink);
        speed = 32;
    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
        ///Verifica daca a fost apasata o tasta
        Map.camera.updateCamera(this);
        if (refLink.GetKeyManager().keyHasBeenPressed()) {


            GetInput();
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

    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;

        if(refLink.GetKeyManager().up) {
            direction = "up";
        } else if(refLink.GetKeyManager().down) {
            direction = "down";
        } else if(refLink.GetKeyManager().left) {
            direction = "left";
        } else if(refLink.GetKeyManager().right) {
            direction = "right";
        }

        collisionOn = false;
        refLink.GetGame().getCollisionChecker().checkTile(this);
        int objIndex = refLink.GetGame().getCollisionChecker().checkItem(this);
        pickItem(objIndex);

        // ENEMY COLLISION
        int enemyIndex = refLink.GetGame().getCollisionChecker().checkEntity(this);
        enemyInteract(enemyIndex);
        // EVENTS
        eventHandler.checkEvent(refLink.GetMap().getName());

        if (collisionOn == false)
        {
            switch (direction)
            {
                case "up": yMove = -speed; break;
                case "down": yMove = speed; break;
                case "left": xMove = -speed; break;
                case "right": xMove = speed;
            }
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics2D g2d)
    {
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
        g2d.drawImage(image,screenX,screenY,width,height,null);

        // CollisionBox
        g2d.setColor(Color.BLUE);
        g2d.fillRect(screenX + bounds.x, screenY + bounds.y, bounds.width, bounds.height);

    }


    private void pickItem(int i){
        if (i != 999) {
            String itemName = refLink.GetMap().items[i].getName();
            switch (itemName) {
                case "key":
                    keys++;
                    refLink.GetMap().items[i] = null;
                    System.out.println("Keys: " + keys);
                    break;
                case "coin":
                    coins++;
                    refLink.GetMap().items[i] = null;
                    System.out.println("Coins: " + coins);
            }
        }
    }

    private void enemyInteract(int i) {
        if (i != 999) {
            System.out.println("Enemy collision");
        }
    }
    @Override
    public int getKeys() {
        return this.keys;
    }
    @Override
    public void setKeys(int keys) {
        this.keys = keys;
    }
}