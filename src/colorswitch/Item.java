package colorswitch;

/**
 * Classe abstraite représentant un item (powerup/champignon/...)
 */
public abstract class Item extends LevelElement {

    protected int color;

    public Item(double x, double y) {
        super(x, y);
    }
}
