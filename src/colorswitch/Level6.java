package colorswitch;

public class Level6 extends Level{

    public Level6(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        Square obstacle1 = new Square(x, 10 * screenHeight, 10);
        Square obstacle2 = new Square(x, 10 * screenHeight, 20);
        Square obstacle3 = new Square(x, 10 * screenHeight, 30);
        Square obstacle4 = new Square(x, 10 * screenHeight, 40);
        VerticalBar obstacle5 = new VerticalBar(x, 5 * screenHeight, 10, 60);
        Square obstacle6 = new Square(x, 10 * screenHeight, 50);
        Square obstacle7 = new Square(x, 10 * screenHeight, 60);
        Square obstacle8 = new Square(x, 10 * screenHeight, 70);
        Square obstacle9 = new Square(x, 10 * screenHeight, 80);

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