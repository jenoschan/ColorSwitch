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

    //todo rework the collision
    @Override
    public boolean intersects(Player player) {
        return this.color != player.getColor()
                && player.getX() + player.getRadius() < this.getX() + this.getWidth() / 2 //right
                && player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2 //left
                && player.getY() + player.getRadius() < this.getY() + this.getHeight() / 2 //down
                && player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2; //up
    }
}
