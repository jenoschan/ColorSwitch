package colorswitch;

public class Level10 extends Level{

    public Level10(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        RotatingCircle obstacle1 = new RotatingCircle(x, 2 * screenHeight, 50);
        VerticalBar obstacle2 = new VerticalBar(x, 5 * screenHeight, 50, 60);
        RotatingCircle obstacle3 = new RotatingCircle(x, 2 * screenHeight, 50);
        VerticalBar obstacle4 = new VerticalBar(x, 5 * screenHeight, 50, 60);
        RotatingCircle obstacle5 = new RotatingCircle(x, 2 * screenHeight, 50);
        VerticalBar obstacle6 = new VerticalBar(x, 5 * screenHeight, 50, 60);
        RotatingCircle obstacle7 = new RotatingCircle(x, 2 * screenHeight, 50);
        VerticalBar obstacle8 = new VerticalBar(x, 5 * screenHeight, 50, 60);

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
        Shield shield = new Shield(x, 2.3* screenHeight);



        items.add(potion1);
        items.add(shield);


        victoryMushroom = new Mushroom(screenWidth / 2, 6 * screenHeight);
    }
}