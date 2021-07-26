package colorswitch;

import javafx.animation.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.ColorAdjust;
import javafx.util.Duration;

import java.awt.*;
import java.security.Key;
import java.sql.Time;

/**
 * Obstacle 2: Vertical Bar : un Rectangle qui bouge de gauche à droite.
 */
public class VerticalBar extends Obstacle {

    private double width;
    private double height;
    private double timeSinceMove =0;
    
    public VerticalBar(double x, double y, double longueur, double hauteur) {
        super(x, y);

        this.width = longueur;
        this.height = hauteur;
        this.renderer = new VerticalRenderer(this);

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

    @Override
    public void tick(double dt) {
        //todo make VerticalBar go left and right

//        timeSinceMove += dt;
//
//        if (timeSinceMove > 2) {
//            //Make it move here?
//            timeSinceMove = 0;
//        }

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
