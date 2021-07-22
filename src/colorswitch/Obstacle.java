package colorswitch;

/**
 * Obstacle dans un niveau.
 *
 * Lorsque le joueur entre en collision avec un obstacle, la partie est
 * terminée.
 */
public abstract class Obstacle extends LevelElement {

    protected int color;

    public Obstacle(double x, double y) {
        super(x, y);
    }

    /**
     * Gestion de la collision entre le joueur et l'obstacle
     *
     * @param player Le joueur
     * @param game La partie en cours
     */
    @Override
    public void handleCollision(Player player, Game game) {
        if (game.invincible() == true){
            game.ok();
        }else {
            game.loose();
        }
    }

}
