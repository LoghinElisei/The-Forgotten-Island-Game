package PaooGame.States;

import PaooGame.Entity.Character;
import PaooGame.Graphics.Button;
import PaooGame.Input.MouseManager;
import PaooGame.Maps.Map;
import PaooGame.Music.Music;
import PaooGame.RefLinks;
import PaooGame.Timer.Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.List;

public class WelcomeState extends State{
    private final ArrayList<Button> buttons;
    private BufferedImage blurredBackground;
    private final Image backgroundImage;
    private String usernameInput = "";
    private String passwordInput = "";
    private boolean usernameSelected = false;
    private boolean passwordSelected = false;

    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public WelcomeState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        buttons = new ArrayList<>();

        int width = 300;
        int height = 70;
        int gap = 20;

        int screenWidth = refLink.GetWidth();
        int screenHeight = refLink.GetHeight();

        int totalMenuHeight = 3 * height + 2 * gap;

        int centerX = (screenWidth - width) / 2;
        int startY = (screenHeight - totalMenuHeight) / 2 + 40; // Am lasat un pic de spatiu pentru titlu

        buttons.add(new Button("Continue", new Rectangle(centerX, startY+250, width, height)));

        backgroundImage = new ImageIcon("res/images/welcome1.png").getImage();

    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        List<java.lang.Character> chars = refLink.GetKeyManager().getTypedCharacters();
        for (char c : chars) {
            if (usernameSelected) {
                usernameInput += c;
            } else if (passwordSelected) {
                passwordInput += c;
            }
        }
        refLink.GetKeyManager().clearTypedCharacters();
        if (refLink.GetKeyManager().isBackspacePressed()) {
            if (usernameSelected && usernameInput.length() > 0) {
                usernameInput = usernameInput.substring(0, usernameInput.length() - 1);
            }
            if (passwordSelected && passwordInput.length() > 0) {
                passwordInput = passwordInput.substring(0, passwordInput.length() - 1);
            }
        }
        System.out.println(usernameInput );
        System.out.println(passwordInput);
        handleMouseHover();
        handleMouseInput();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics2D g2d)
    {
        if (backgroundImage != null) {
            g2d.drawImage(backgroundImage, 0, 0, refLink.GetWidth(), refLink.GetHeight(), null);
        } else {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, refLink.GetWidth(), refLink.GetHeight());
        }

        g2d.setColor(new Color(255,255,255,200));
        g2d.setFont(new Font("Merriweather", Font.BOLD, 50));

        int y = refLink.GetHeight() / 4;  // Higher than buttons

        for (Button b: buttons)
        {
            b.draw(g2d, Color.decode("#FFFFFF"), Color.BLACK, Color.decode("#324700"));
        }

        Rectangle usernameField = new Rectangle(400, 420, 400, 50);
        Rectangle passwordField = new Rectangle(400, 590, 400, 50);
        g2d.setFont(new Font("Cascadia Mono", Font.BOLD, 40));
        g2d.setColor(Color.BLACK);
        g2d.drawString("Username:", 400, 400);
        g2d.drawString("Password:", 400, 570);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(usernameField.x, usernameField.y, usernameField.width, usernameField.height);
        g2d.drawRect(passwordField.x, passwordField.y, passwordField.width, passwordField.height);


        g2d.setFont(new Font("Cascadia Mono", Font.PLAIN, 35));
        g2d.drawString(usernameInput, usernameField.x + 10, usernameField.y + 35);
        g2d.drawString(maskPassword(passwordInput), passwordField.x + 10, passwordField.y + 35);
    }

    private String maskPassword(String password)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            sb.append("*");
        }
        return sb.toString();
    }
    private int getXForCenteredText(String text, Graphics2D g)
    {
        int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
        int x = refLink.GetWidth() / 2  - length / 2;

        return x;
    }


    private void handleMouseHover() {
        Point mousePos = refLink.GetMouseManager().getMousePosition();

        for (Button b: buttons) {
            b.setHovered(b.getBounds().contains(mousePos));
        }
    }

    private void handleMouseInput() {
        MouseManager m = refLink.GetMouseManager();

        Rectangle usernameField = new Rectangle(400, 420, 400, 50);
        Rectangle passwordField = new Rectangle(400, 590, 400, 50);


        if (m.isMouseClicked())
        {
            Point mousePos = m.getMousePosition();
            for (Button b: buttons)
            {
                if (b.getBounds().contains(mousePos)) {
                    handleClick(b.getLabel());
                }
                usernameSelected = usernameField.contains(mousePos);
                passwordSelected = passwordField.contains(mousePos);
            }
        }
        refLink.GetMouseManager().clearMouseClick();
    }

    private boolean loginInfoIsCorrect()
    {
        return usernameInput.equals("admin") && passwordInput.equals("1234");
    }

    private void handleClick(String label)
    {
        if (label.equals("Continue") && loginInfoIsCorrect()) {
            State.SetState(refLink.GetGame().playState);

//            refLink.GetGame().playState = new PlayState(refLink);
//            refLink.setState(refLink.GetGame().playState);
//            State.SetState(refLink.GetGame().playState);
        }
    }

}
