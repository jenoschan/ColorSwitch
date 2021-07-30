package colorswitch;


/**
 * Un rectangle qui change de couleur à toutes les 2 secondes et bouge diagonalement.
 */
public class DiagonalBar extends Obstacle {

    private double width;
    private double height;
    private double yPos = this.getY();
    private double timeSinceColorChange = 0;
    private boolean isPositionL = true;

    /**
     * Constructeur pour l'obstacle.
     * @param x Position de l'obstacle en x
     * @param y Position de l'obstacle en y
     * @param width Largeur de l'obstacle
     * @param height Hauteur de l'obstacle
     */
    public DiagonalBar(double x, double y, double width, double height) {
        super(x, y);

        this.width = width;
        this.height = height;
        this.renderer = new DiagonalRenderer(this);

        this.color = (int) (Math.random() * 4);
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    /**
     * Fonction qui fait bouger la barre de droite à gauche.
     * @param dt Delta-Temps en secondes
     */
    @Override
    public void tick(double dt) {

        timeSinceColorChange += dt;

        if (timeSinceColorChange > 2) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        }


        if (isPositionL) {
            // Move right
            if(x < ColorsWitch.WIDTH - width/2){
                x += dt * 100;
                y += dt * 100;
            }else{
                isPositionL = false;
            }

        } else if ( x > 0 ){
            x -= dt * 100;
            y -= dt * 100;
        } else {
            isPositionL = true;
        }
    }

    public int getColor() {
        return color;
    }


    @Override
    public boolean intersects(Player player) {
        return this.color != player.getColor()
                && player.getX() + player.getRadius() < this.getX() + this.getWidth() / 2
                && player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
                && player.getY() + player.getRadius() < this.getY() + this.getHeight() / 2
                && player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
    }
}