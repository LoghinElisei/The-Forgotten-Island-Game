package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;
    public static BufferedImage soil;
    public static BufferedImage grass;
    public static BufferedImage water;
    public static BufferedImage greenTree;
    public static BufferedImage yellowTree;
    public static BufferedImage stone;
    public static BufferedImage bridge;
    public static BufferedImage coin ;
    public static BufferedImage key;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/SpriteSheet.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/SpriteSheet2.png"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.LoadImage("/textures/SpriteSheet3.png"));
        SpriteSheet mcSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/mainCharacter.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.
//        grass = sheet.crop(50, 95);
////        soil = sheet.crop(4, 2);
////        water = sheet3.crop(10, 95);
////        greenTree = sheet.crop(25, 13);
////        yellowTree = sheet.crop(21,13);
////        stone = sheet.crop(61,11);
////        bridge = sheet.crop(11,18);
////        coin = sheet.crop(42,40);
////        key = sheet.crop(56,40);

        grass = sheet.crop(25, 9);
        water = sheet3.crop(1, 1);
        greenTree = sheet.crop(14, 13);
        yellowTree = sheet.crop(16,13);
        soil = sheet.crop(2, 4);
        bridge = sheet.crop(11,18);
        coin = sheet.crop(41,40);
        key = sheet.crop(55,40);
        stone = sheet.crop(60,11);

        heroLeft = mcSheet.crop(1, 1);
        heroRight = mcSheet.crop(1, 2);
    }
}