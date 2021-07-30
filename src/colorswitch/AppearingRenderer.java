package colorswitch;

import javafx.scene.canvas.GraphicsContext;


/**
 * Fait le rendu d'un Cercle qui change de position en x aléatoirement.
 */
public class AppearingRenderer extends Renderer {

    private AppearingCircle circle;

    public AppearingRenderer(AppearingCircle c) {
        this.circle = c;
    }

    /**
     * Fonction qui dessine le cercle dans le niveau.
     * @param level Niveau dans lequel dessiner.
     * @param context Endroit ou dessiner.
     */
    @Override
    public void draw(Level level, GraphicsContext context) {

        double canvasY = Renderer.computeScreenY(level, circle.getY());

        context.setFill(Renderer.convertColor(circle.getColor()));

        context.fillOval(
                circle.getX() - circle.getWidth() / 2,
                canvasY - circle.getWidth() / 2,
                circle.getWidth(),
                circle.getWidth());

    }

}
