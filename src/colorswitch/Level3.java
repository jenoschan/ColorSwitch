package colorswitch;
/**
 * Niveau 3
 */
public class Level3 extends Level{

    public Level3(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        Square obstacle1 = new Square(x, 0.75 * screenHeight, 40);
        Square obstacle2 = new Square(x, 2 * screenHeight, 60);
        Square obstacle3 = new Square(x, 3 * screenHeight, 150);
        Square obstacle4 = new Square(x, 3.6 * screenHeight, 200);
        VerticalBar obstacle5 = new VerticalBar(x, 2.6 * screenHeight, 40, 100);
        GrowingCircle obstacle6 = new GrowingCircle(x, 1.25 * screenHeight, 25);
        RotatingCircle obstacle7 = new RotatingCircle(x, 4.2 * screenHeight, 30);
        VerticalBar obstacle8 = new VerticalBar(x, 5.6 * screenHeight, 40, 200);

        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);
        obstacles.add(obstacle7);
        obstacles.add(obstacle8);

        // Création des items
        Potion potion1 = new Potion(x, 1 * screenHeight);
        Potion potion2 = new Potion(x, 3.2 * screenHeight);
        Potion potion3 = new Potion(x, 5 * screenHeight);

        Shield shield = new Shield(x, 2.3* screenHeight);

        items.add(potion1);
        items.add(potion2);
        items.add(shield);

        victoryMushroom = new Mushroom(screenWidth / 2, 6 * screenHeight);
    }
}
