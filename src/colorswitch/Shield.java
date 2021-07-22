package colorswitch;

/**
 * Item : Shield.
 *
 * La sorcière devient invincible pendant 3s.
 */
public class Shield extends Item {

    private boolean used = false;

    public Shield(double x, double y) {
        super(x, y);

        this.renderer = new ImageRenderer("shield", this);
    }

    @Override
    public void tick(double dt) {
        // Rien à faire
    }

    @Override
    public double getWidth() {
        return 48;
    }

    @Override
    public double getHeight() {
        return 48;
    }

    @Override
    public void handleCollision(Player player, Game game) {
        used = true;
        this.renderer = new ImageRenderer("shield", this);
        //todo make invincible for 3s.
    }

    @Override
    public boolean intersects(Player player) {
        return !used
                && player.getX() < this.getX() + this.getWidth() / 2
                && player.getX() > this.getX() - this.getWidth() / 2
                && player.getY() < this.getY() + this.getHeight() / 2
                && player.getY() > this.getY() - this.getHeight() / 2;
    }
}
