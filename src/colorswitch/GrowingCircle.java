package colorswitch;

/**
 * Obstacle simple : un cercle qui change de couleur à toutes les 2 secondes & pulse.
 */
public class GrowingCircle extends Obstacle {

    private double width;
    private double timeSinceColorChange = 0;
    private boolean isGrowing = true;

    public GrowingCircle(double x, double y, double width) {
        super(x, y);

        this.width = width;
        this.renderer = new GrowingRenderer(this);

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

        if(isGrowing) {
            if (width < ColorsWitch.WIDTH/3) {
                width += dt * 10;
            }else{
                isGrowing = false;
            }
        } else if ( width > 40 ){
                width -= dt * 10;
            } else {
                isGrowing = true;
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