package colorswitch;

/**
 * Niveau 1
 */
public class Level1 extends Level {

    public Level1(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        Square obstacle1 = new Square(x, 0.75 * screenHeight, 40);
        Square obstacle2 = new Square(x, 1.5 * screenHeight, 60);
        Square obstacle3 = new Square(x, 2.0 * screenHeight, 150);
        Square obstacle4 = new Square(x, 3 * screenHeight, 200);
        VerticalBar obstacle5 = new VerticalBar(x, 4 * screenHeight, 40, 100);
        GrowingCircle obstacle6 = new GrowingCircle(x, 3.5 * screenHeight, 25);
        RotatingCircle obstacle7 = new RotatingCircle(0, 5 * screenHeight, 25);
        DiagonalBar obstacle8 = new DiagonalBar(x, 5.3 * screenHeight, 40, 100);
        AppearingCircle obstacle9 = new AppearingCircle(x, 0.5 * screenHeight, 40);

        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);
        obstacles.add(obstacle7);
        obstacles.add(obstacle8);
        obstacles.add(obstacle9);

        // Création des items
        ColorChange colorChange = new ColorChange(x,0.2 * screenHeight);
        Potion potion1 = new Potion(x, 1.15 * screenHeight);
        Potion potion2 = new Potion(x, 2.6 * screenHeight);
        Spring speed = new Spring(x, 4.6 * screenHeight);
        Shield shield = new Shield(x, 1* screenHeight);

        items.add(colorChange);
        items.add(potion1);
        items.add(potion2);
        items.add(shield);
        items.add(speed);

        victoryMushroom = new Mushroom(screenWidth / 2, 6 * screenHeight);
    }
}
