package colorswitch;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Item : ColorChange.
 *
 * La sorcière change de couleur automatiquement.
 */
public class ColorChange extends Item {

    private boolean used = false;


    public ColorChange(double x, double y) {
        super(x, y);

        this.renderer = new ImageRenderer("color_changing", this);

    }

    @Override
    public void tick(double dt) {
        //Rien
    }

    @Override
    public double getWidth() {
        return 32;
    }

    @Override
    public double getHeight() {
        return 32;
    }

    /**
     *  Fonction qui vérifie si le joueur entre en collision
     * @param player Le joueur
     * @param game Le contexte du jeu
     */
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
