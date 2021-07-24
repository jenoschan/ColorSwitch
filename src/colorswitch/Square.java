package colorswitch;

/**
 * Obstacle simple : un carré qui change de couleur à toutes les 2 secondes.
 */
public class Square extends Obstacle {

    private double width;
    private double timeSinceColorChange = 0;

    public Square(double x, double y, double longueur) {
        super(x, y);

        this.width = longueur;
        this.renderer = new SquareRenderer(this);

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

    @Override
    public void tick(double dt) {
        timeSinceColorChange += dt;

        if (timeSinceColorChange > 2) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        }
    }

    public int getColor() {
        return color;
    }

    @Override
    public boolean intersects(Player player) {
        return this.color != player.getColor()
                && player.getX() + player.getRadius()< this.getX() + this.getWidth() / 2
                && player.getX() + player.getRadius()> this.getX() - this.getWidth() / 2
                && player.getY() + player.getRadius()< this.getY() + this.getHeight() / 2
                && player.getY() + player.getRadius()> this.getY() - this.getHeight() / 2;
    }
}
