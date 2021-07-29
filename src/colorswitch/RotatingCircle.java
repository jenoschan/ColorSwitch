package colorswitch;


/**
 * Obstacle simple : un cercle qui change de couleur à toutes les 2 secondes et "rotate".
 */
public class RotatingCircle extends Obstacle {

    private double width;
    private double timeSinceColorChange = 0;
    private double yPos = this.getY();
    private double time;

    public RotatingCircle(double x, double y, double width) {
        super(x, y);

        this.width = width;
        this.renderer = new RotatingRenderer(this);

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

        if (timeSinceColorChange > 4) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        }

        time += (1/60.0);

        x = 100 * Math.cos(time) + ColorsWitch.WIDTH/2;
        y = 100 * Math.sin(time) + yPos;
    }

    public int getColor() {
        return color;
    }


    //todo rework the collision
    @Override
    public boolean intersects(Player player) {
        return this.color != player.getColor()
                && player.getX() + player.getRadius() < this.getX() + this.getWidth() / 2
                && player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
                && player.getY() + player.getRadius() < this.getY() + this.getHeight() / 2
                && player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
    }
}