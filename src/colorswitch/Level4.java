package colorswitch;
/**
 * Niveau 4
 */
public class Level4 extends Level{

    public Level4(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        Square obstacle1 = new Square(x, 5 * screenHeight, 20);
        RotatingCircle obstacle2 = new RotatingCircle(x, 3 * screenHeight, 60);
        VerticalBar obstacle3 = new VerticalBar(x, 3 * screenHeight, 50, 70);
        Square obstacle4 = new Square(x, 3.6 * screenHeight, 200);
        GrowingCircle obstacle5 = new GrowingCircle(x, 2.25 * screenHeight, 65);
        GrowingCircle obstacle6 = new GrowingCircle(x, 1.25 * screenHeight, 25);
        RotatingCircle obstacle7 = new RotatingCircle(x, 4.2 * screenHeight, 30);
        Square obstacle8 = new Square(x, 10 * screenHeight, 40);

        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);
        obstacles.add(obstacle7);
        obstacles.add(obstacle8);

        // Création des items
        Potion potion1 = new Potion(x, 4 * screenHeight);
        Potion potion2 = new Potion(x, 2.8 * screenHeight);
        Potion potion3 = new Potion(x, 1 * screenHeight);

        Shield shield = new Shield(x, 2.3* screenHeight);

        items.add(potion1);
        items.add(potion2);
        items.add(shield);

        victoryMushroom = new Mushroom(screenWidth / 2, 6 * screenHeight);
    }
}
