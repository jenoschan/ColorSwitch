package colorswitch;
/**
 * Niveau 5
 */
public class Level5 extends Level{

    public Level5(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        RotatingCircle obstacle1 = new RotatingCircle(x, 2 * screenHeight, 60);
        RotatingCircle obstacle2 = new RotatingCircle(x, 3 * screenHeight, 60);
        RotatingCircle obstacle3 = new RotatingCircle(x, 4 * screenHeight, 60);
        VerticalBar obstacle4 = new VerticalBar(x, 5 * screenHeight, 10, 60);
        GrowingCircle obstacle5 = new GrowingCircle(x, 2.25 * screenHeight, 65);
        GrowingCircle obstacle6 = new GrowingCircle(x, 3.25 * screenHeight, 65);
        GrowingCircle obstacle7 = new GrowingCircle(x, 4.25 * screenHeight, 65);
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
        Potion potion1 = new Potion(x, 2 * screenHeight);
        Potion potion2 = new Potion(x, 3 * screenHeight);
        Potion potion3 = new Potion(x, 4 * screenHeight);

        Shield shield = new Shield(x, 2.3* screenHeight);

        items.add(potion1);
        items.add(potion2);
        items.add(potion3);
        items.add(shield);

        victoryMushroom = new Mushroom(screenWidth / 2, 6 * screenHeight);
    }
}
