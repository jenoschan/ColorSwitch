package colorswitch;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Item : Shield.
 *
 * La sorcière change de couleur automatiquement.
 */
public class ColorChange extends Item {

    private boolean used = false;
    private double timeSinceColorChange = 0;

    public ColorChange(double x, double y) {
        super(x, y);

        this.renderer = new ImageRenderer("color_changing", this);

        this.color = (int) (Math.random() * 4);
    }

    @Override
    public void tick(double dt) {
        timeSinceColorChange += dt;

        if (timeSinceColorChange > 2) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        }
    }

    @Override
    public double getWidth() {
        return 32;
    }

    @Override
    public double getHeight() {
        return 32;
    }

    @Override
    public void handleCollision(Player player, Game game) {
        used = true;
        this.renderer = new ImageRenderer("color_changing", this);

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
               player.randomizeColor();
            }
        }, 0, 5000);
    }

    public boolean isUsed() {
        return used;
    }

    @Override
    public boolean intersects(Player player) {
        return !used
                && player.getX() + player.getRadius() < this.getX() + this.getWidth() / 2
                && player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
                && player.getY() + player.getRadius() < this.getY() + this.getHeight() / 2
                && player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
    }
}