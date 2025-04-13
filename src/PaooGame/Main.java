package PaooGame;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = Game.getGame("PaooGame", 960, 480);
        paooGame.StartGame();
    }
}
