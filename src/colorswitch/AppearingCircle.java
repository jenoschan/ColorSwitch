package colorswitch;


/**
 * Un cercle qui change de couleur à toutes les 2 secondes & change de position en x aléatoirement.
 */
public class AppearingCircle extends Obstacle {

    private double width;
    private double timeSinceColorChange = 0;
    private double timeSinceMove = 0;

    /**
     *
     * @param x Position en X du cercle
     * @param y Position en Y du cercle
     * @param width Largeur du cercle
     */
    public AppearingCircle(double x, double y, double width) {
        super(x, y);

        this.width = width;
        this.renderer = new AppearingRenderer(this);

        this.color = (int) (Math.random() * 4);
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return width;
    }

    /**
     * Fonction qui anime le cercle
     * @param dt Delta-Temps en secondes
     */
    @Override
    public void tick(double dt) {
        timeSinceColorChange += dt;
        timeSinceMove += dt;

        if (timeSinceColorChange > 4) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        } if (timeSinceMove > 0.5){
            x = ColorsWitch.WIDTH * Math.random();
            timeSinceMove = 0;
        }

    }

    public int getColor() {
        return color;
    }

    /**
     *
     * @param player
     * @return Retourne vrai ou faux selon si le joueur a une interesction avec l'objet.
     */
    @Override
    public boolean intersects(Player player) {
        return this.color != player.getColor()
                && player.getX() + player.getRadius() < this.getX() + this.getWidth() / 2
                && player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
                && player.getY() + player.getRadius() < this.getY() + this.getHeight() / 2
                && player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
    }
}