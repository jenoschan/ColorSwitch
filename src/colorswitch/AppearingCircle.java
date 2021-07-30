package colorswitch;

import java.awt.*;

/**
 * Un cercle qui change de couleur à toutes les 2 secondes & change de position en x.
 */
public class AppearingCircle extends Obstacle {

    private double width;
    private double timeSinceColorChange = 0;
    private double timeSinceMove = 0;

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

    @Override
    public boolean intersects(Player player) {
        return this.color != player.getColor()
                && player.getX() + player.getRadius() < this.getX() + this.getWidth() / 2
                && player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
                && player.getY() + player.getRadius() < this.getY() + this.getHeight() / 2
                && player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
    }
}