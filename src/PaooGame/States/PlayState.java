package PaooGame.States;

import PaooGame.Creator.HeroCreator.HeroItemCreator;
import PaooGame.Creator.ItemCreator;
import PaooGame.Creator.ItemType;
import PaooGame.Items.Hero;
import PaooGame.Items.Item;
import PaooGame.Maps.Map;
import PaooGame.Maps.Map2;
import PaooGame.Maps.Map3;
import PaooGame.RefLinks;
import PaooGame.Maps.Map1;
import PaooGame.Tiles.Tile;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Item hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink) {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map3(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
            ///Construieste eroul
        ItemCreator heroCreator = new HeroItemCreator();
        hero = heroCreator.getItem(ItemType.HERO, refLink,1050, 2050);
    }
    public void CheckCurrentTile(Item player, Map map) {
        // Coordonatele absolute ale jucătorului
        float playerX = player.GetX()/4;
        float playerY = player.GetY()/4;

        // Calcularea coordonatelor tile-ului
        int tileX = (int)(playerX / Tile.TILE_WIDTH);
        int tileY = (int)(playerY / Tile.TILE_HEIGHT);
        System.out.println("Player position in pixels: (" + playerX + ", " + playerY + ")");
        System.out.println("Tile coordinates: (" + tileX + ", " + tileY + ")");

        map.GetCollisionTile(tileX,tileY).IsSolid();
        System.out.println(map.GetCollisionTile(tileX,tileY).toString());
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();
        CheckCurrentTile(hero,map);
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics2D g)
    {
        map.Draw(g);
        hero.Draw(g);
    }
}