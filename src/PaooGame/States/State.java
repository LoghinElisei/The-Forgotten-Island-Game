package PaooGame.States;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import PaooGame.Database.DatabaseManager;
import PaooGame.RefLinks;

/*! \class State
    \brief Implementeaza notiunea abstracta de stare a jocului/programului.

    Un joc odata ce este lansat in executie nu trebuie "sa arunce jucatorul direct in lupta", este nevoie de
    un meniu care sa contine optiuni: New PaooGame.Game, Load PaooGame.Game, Settings, About etc. Toate aceste optiuni nu sunt altceva
    decat stari ale programului (jocului) ce trebuiesc incarcate si afisate functie de starea curenta.
 */
public abstract class State
{
        ///Urmatoarele atribute sunt statice pentru a evita dealocarea spatiului de memorie la trecerea dintr-o stare in alta.
    private static State previousState  = null; /*!< Referinta catre starea anterioara a jocului.*/
    private static State currentState   = null; /*!< Referinta catre starea curenta a jocului: game, meniu, settings, about etc.*/
    protected RefLinks refLink;
    public State(RefLinks refLink)
    {
        this.refLink = refLink;
    }
    DatabaseManager database = DatabaseManager.getInstance();


    /*! \fn public static void SetState(State state)
        \brief Seteaza starea curenta a jocului.

        \param state Noua stare a programului (jocului).
     */
    public static void SetState(State state)
    {
        previousState = currentState;
        currentState = state;
    }
    protected BufferedImage applyBlur(BufferedImage src)
    {
        float[] kernel = {
                1f/9f, 1f/9f, 1f/9f,
                1f/9f, 1f/9f, 1f/9f,
                1f/9f, 1f/9f, 1f/9f
        };

        ConvolveOp op = new ConvolveOp(
                new Kernel(3, 3, kernel),
                ConvolveOp.EDGE_NO_OP,
                null
        );
        for (int i = 0; i < 7; ++i)
        {
            src = op.filter(src, null);
        }
        return src;
    }
    public static State GetState()
    {
        return currentState;
    }

        ///Metoda abstracta destinata actualizarii starii curente
    public abstract void Update();
        ///Metoda abstracta destinata desenarii starii curente
    public abstract void Draw(Graphics2D g);
}