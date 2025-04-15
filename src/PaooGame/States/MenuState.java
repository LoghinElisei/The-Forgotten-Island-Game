<<<<<<< HEAD
package PaooGame.States;

import PaooGame.Graphics.ImageLoader;
import PaooGame.Input.MouseManager;
import PaooGame.RefLinks;
import PaooGame.Graphics.Button;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de meniu pentru joc.
 */
public class MenuState extends State
{
    private ArrayList<Button> buttons;
    private BufferedImage backgroundImage;

    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        buttons = new ArrayList<>();

        int width = 200;
        int height = 50;
        int gap = 20;

        int screenWidth = refLink.GetWidth();
        int screenHeight = refLink.GetHeight();

        int totalMenuHeight = 4 * height + 2 * gap;

        int centerX = (screenWidth - width) / 2;
        int startY = (screenHeight - totalMenuHeight) / 2 + 20; // Am lasat un pic de spatiu pentru titlu

        buttons.add(new Button("Load Game", new Rectangle(centerX, startY + buttons.size() * (height + gap), width, height)));
        buttons.add(new Button("New Game", new Rectangle(centerX, startY + buttons.size() * (height + gap), width, height)));
        buttons.add(new Button("ScoreBoard", new Rectangle(centerX, startY + buttons.size() * (height + gap), width, height)));
        buttons.add(new Button("Leave", new Rectangle(centerX, startY + buttons.size() * (height + gap), width, height)));

        backgroundImage = ImageLoader.LoadImage("/images/island_animated.gif");
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        handleMouseHover();
        handleMouseInput();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        if (backgroundImage != null) {
            int imageWidth = backgroundImage.getWidth();
            int imageHeight = backgroundImage.getHeight();

            int centerX = (refLink.GetWidth() - imageWidth) / 2;
            int centerY = (refLink.GetHeight() - imageHeight) / 2;

            g.drawImage(backgroundImage, centerX, centerY, null);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, refLink.GetWidth(), refLink.GetHeight());
        }

        g.setColor(Color.decode("#00697d"));
        g.setFont(new Font("Roboto", Font.BOLD, 48));
        String text = "MAIN MENU";

        int x = getXForCenteredText(text, g);
        int y = refLink.GetHeight() / 4;  // Higher than buttons

        g.drawString(text, x, y);
        for (Button b: buttons)
        {
            b.draw(g, Color.decode("#0E161B"), Color.decode("#0E161B"), Color.decode("#C0C49C"));
        }
    }

    private int getXForCenteredText(String text, Graphics g)
    {
        int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
        int x = refLink.GetWidth() / 2  - length / 2;

        return x;
    }

    private void handleMouseInput() {
        MouseManager m;
        m = refLink.GetMouseManager();

        if (m.isMouseClicked())
        {
            Point mousePos = m.getMousePosition();
            for (Button b: buttons)
            {
                if (b.getBounds().contains(mousePos)) {
                    handleClick(b.getLabel());
                }
            }
        }

        refLink.GetMouseManager().clearMouseClick();
    }

    private void handleMouseHover() {
        Point mousePos = refLink.GetMouseManager().getMousePosition();

        for (Button b: buttons) {
            b.setHovered(b.getBounds().contains(mousePos));
        }
    }
    private void handleClick(String label)
    {
        switch (label) {
            case "Load Game":
                System.out.println("Load Game");
                break;
            case "New Game":
                State.SetState(refLink.GetGame().playState);
                break;
            case "ScoreBoard":
                System.out.println("Loading ScoreBoard...");
                break;
            case "Leave":
                System.exit(0);
        }
    }

}
=======
package PaooGame.States;

import PaooGame.RefLinks;

import java.awt.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {

    }
}
>>>>>>> elisei
