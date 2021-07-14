package colorswitch;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Fait le rendu d'une Entity sur l'écran en affichant une image
 */
public class ImageRenderer extends Renderer {

    private Image img;
    private Entity entity;

    public ImageRenderer(String name, Entity e) {
        img = new Image("/" + name + ".png");
        this.entity = e;
    }

    @Override
    public void draw(Level level, GraphicsContext context) {

        double x = entity.getX();
        double y = Renderer.computeScreenY(level, entity.getY());

        context.drawImage(img, x - entity.getWidth() / 2, y - entity.getHeight() / 2, entity.getWidth(), entity.getHeight());
    }
}
