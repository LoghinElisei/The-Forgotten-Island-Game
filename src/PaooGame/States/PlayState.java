package PaooGame.States;

import PaooGame.Creator.HeroCreator.HeroItemCreator;
import PaooGame.Creator.ItemCreator;
import PaooGame.Creator.ItemType;
import PaooGame.Entity.Character;
import PaooGame.Entity.Entity;
import PaooGame.Game;
import PaooGame.Maps.Map;
import PaooGame.Maps.Map1;
import PaooGame.Maps.Map2;
import PaooGame.Maps.Map3;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    public static Map map;    /*!< Referinta catre harta curenta.*/

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink) {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map1(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
            ///Construieste eroul
        ItemCreator heroCreator = new HeroItemCreator();
        hero = heroCreator.getItem(ItemType.HERO, refLink,1050, 2050);
        Game.debugState = false;

    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();

        // ENEMIES
        for (int i = 0; i < map.monsters.length; ++i)
        {
            if (map.monsters[i] != null)
            {
                map.monsters[i].Update();
            }
        }

        Map.timer.start();

        // DEBUG
        if (refLink.GetKeyManager().IsDebugJustPressed()) {
            Game.debugState = !Game.debugState;
            if (Game.debugState) {
                hero.SetSpeed(30);
            } else {
                hero.SetSpeed(Character.DEFAULT_SPEED);
            }

        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics2D g)
    {
        map.Draw(g);
        // OBJECTS
        for (int i = 0; i < map.items.length; ++i)
        {
            if (map.items[i] != null)
            {
                map.items[i].draw(g, hero);
            }
        }

        // ENEMIES
        for (int i = 0; i < map.monsters.length; ++i)
        {
            if (map.monsters[i] != null)
            {
                map.monsters[i].Draw(g);
            }
        }
        hero.Draw(g);

        // DEBUG
        if (Game.debugState) {
            g.setFont(new Font("Arial", Font.PLAIN, 30));
            g.setColor(Color.WHITE);
            int x = 10, y = 400, lineHeight = 20;

            g.drawString("x: " + hero.GetX(), x, y); y += lineHeight;
            g.drawString("y: " + hero.GetY(), x, y); y += lineHeight;
            g.drawString("Col: " + (hero.GetX() + hero.bounds.x) / Tile.TILE_WIDTH , x, y); y += lineHeight;
            g.drawString("Row: " + (hero.GetY() + hero.bounds.y) / Tile.TILE_WIDTH , x, y);
        }
    }
    public static void setMap(Map map){
        PlayState.map = map;
    }
}