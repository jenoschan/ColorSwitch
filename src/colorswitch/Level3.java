package colorswitch;

public class Level3 extends Level{

    public Level3(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        Square obstacle1 = new Square(screenWidth / 2, screenHeight * 2, screenHeight * 1.9);

        obstacles.add(obstacle1);

        victoryMushroom = new Mushroom(screenWidth / 2, 100 * screenHeight);
    }
}
