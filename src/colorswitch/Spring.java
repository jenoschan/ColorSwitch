package colorswitch;

/**
 * Item : Spring.
 *
 * La sorcière se fait repousser.
 */
public class Spring extends Item {

    private boolean used = false;
    private double vy;
    private double ay;

    public Spring(double x, double y) {
        super(x, y);

        this.vy = 0;
        this.ay = 400;

        this.renderer = new ImageRenderer("spring", this);
    }

    @Override
    public void tick(double dt) {
        vy -= dt * ay;
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
        this.renderer = new ImageRenderer("spring", this);
        player.setVy(vy);
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
