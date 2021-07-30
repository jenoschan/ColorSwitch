package colorswitch;
/**
 * Niveau 9
 */
public class Level9 extends Level{

    public Level9(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        GrowingCircle obstacle1 = new GrowingCircle(x, 2.25 * screenHeight, 35);
        GrowingCircle obstacle2 = new GrowingCircle(x, 2.25 * screenHeight, 15);
        GrowingCircle obstacle3 = new GrowingCircle(x, 2.25 * screenHeight, 35);
        GrowingCircle obstacle4 = new GrowingCircle(x, 2.25 * screenHeight, 15);
        GrowingCircle obstacle5 = new GrowingCircle(x, 2.25 * screenHeight, 35);
        GrowingCircle obstacle6 = new GrowingCircle(x, 2.25 * screenHeight, 15);
        GrowingCircle obstacle7 = new GrowingCircle(x, 2.25 * screenHeight, 35);
        GrowingCircle obstacle8 = new GrowingCircle(x, 2.25 * screenHeight, 15);

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


        items.add(potion1);
        items.add(potion2);
        items.add(potion3);


        victoryMushroom = new Mushroom(screenWidth / 2, 6 * screenHeight);
    }
}