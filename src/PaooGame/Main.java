<<<<<<< HEAD
package PaooGame;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = Game.getGame("PaooGame", 960, 480);
        paooGame.StartGame();
    }
}
=======
package PaooGame;

import PaooGame.GameWindow.GameWindow;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = new Game("PaooGame", 1408, 1056);
        paooGame.StartGame();
    }
}
>>>>>>> elisei
