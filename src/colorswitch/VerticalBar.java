package colorswitch;

/**
 * Obstacle 2: Vertical Bar : un Rectangle qui bouge de gauche à droite.
 */
public class VerticalBar extends Obstacle {

    private double width;
    private double height;

    private boolean isPositionL = true;

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
        if (isPositionL) {
            // Move right
            if(x < ColorsWitch.WIDTH - width/2){
                x += dt * 100;
            }else{
                isPositionL = false;
            }

        } else if ( x > 0 ){
            x -= dt * 100;
        } else {
            isPositionL = true;
        }

    }


    public int getColor() {
        return color;
    }


    @Override
    public boolean intersects(Player player) {
        double NearestX = Math.max(this.getX(), Math.min(player.getX(), this.getX() + this.getWidth()));
        double NearestY = Math.max(this.getY(), Math.min(player.getY(), this.getY() + this.getHeight()));
        double DeltaX = player.getX() - NearestX;
        double DeltaY = player.getY() - NearestY;
        return this.color != player.getColor()
                && (DeltaX * DeltaX + DeltaY * DeltaY) < (player.getRadius() * player.getRadius());

    }
}
