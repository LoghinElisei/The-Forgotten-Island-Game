package PaooGame.States;

import PaooGame.Input.MouseManager;
import PaooGame.RefLinks;
import PaooGame.Graphics.Button;
import java.awt.*;
import java.awt.Rectangle;
import java.util.ArrayList;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de meniu pentru joc.
 */
public class PauseState extends State
{
    private final ArrayList<Button> buttons;

    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PauseState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        buttons = new ArrayList<>();

        int width = 200;
        int height = 50;
        int gap = 20;

        int screenWidth = refLink.GetWidth();
        int screenHeight = refLink.GetHeight();

        int totalMenuHeight = 3 * height + 2 * gap;

        int centerX = (screenWidth - width) / 2;
        int startY = (screenHeight - totalMenuHeight) / 2 + 60; // Am lasat un pic de spatiu pentru titlu


        buttons.add(new Button("Continue", new Rectangle(centerX, startY, width, height)));
        buttons.add(new Button("Save", new Rectangle(centerX, startY + height + gap, width, height)));
        buttons.add(new Button("Exit", new Rectangle(centerX, startY + 2 * (height + gap), width, height)));
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        handleMouseInput();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, refLink.GetWidth(), refLink.GetHeight());

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        String text = "PAUSE";
        int x = getXForCenteredText(text, g);
        int y = refLink.GetHeight() / 4;  // Higher than buttons

        g.drawString(text, x, y);


        for (Button b: buttons)
        {
            b.draw(g);
        }
    }

    private int getXForCenteredText(String text, Graphics g)
    {
        int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
        int x = refLink.GetWidth() / 2  - length / 2;

        return x;
    }

    private void handleMouseInput() {
        MouseManager m = refLink.GetMouseManager();
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
    private void handleClick(String label)
    {
        switch (label) {
            case "Continue":
                State.SetState(refLink.GetGame().playState);
                break;
            case "Save":
                System.out.println("Game Saved!");
                break;
            case "Exit":
                State.SetState(refLink.GetGame().menuState);
                break;
        }
    }

}
