package colorswitch;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * Item : Shield.
 *
 * La sorcière devient invincible pendant 3s.
 */
public class Speed extends Item {

    private boolean used = false;
    private double vy;
    private double ay;

    public Shield(double x, double y) {
        super(x, y);

        this.vy = 0;
        this.ay = -400;

        this.renderer = new ImageRenderer("fast_forward", this);
    }

    @Override
    public void tick(double dt) {
        vy += dt * ay * 2;

        vy = Math.min(vy, 300);
        vy = Math.max(vy, -300);
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
        this.renderer = new ImageRenderer("fast_forward", this);
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
