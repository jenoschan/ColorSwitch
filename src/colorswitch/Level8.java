package colorswitch;

public class Level8 extends Level{

    public Level8(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        VerticalBar obstacle1 = new VerticalBar(x, 5 * screenHeight, 20, 60);
        VerticalBar obstacle2 = new VerticalBar(x, 5 * screenHeight, 20, 60);
        VerticalBar obstacle3 = new VerticalBar(x, 5 * screenHeight, 20, 60);
        VerticalBar obstacle4 = new VerticalBar(x, 5 * screenHeight, 20, 60);
        VerticalBar obstacle5 = new VerticalBar(x, 5 * screenHeight, 20, 60);
        VerticalBar obstacle6 = new VerticalBar(x, 5 * screenHeight, 20, 60);
        VerticalBar obstacle7 = new VerticalBar(x, 5 * screenHeight, 20, 60);
        VerticalBar obstacle8 = new VerticalBar(x, 5 * screenHeight, 20, 60);

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