package colorswitch;

import javafx.scene.canvas.GraphicsContext;


/**
 * Fait le rendu d'un Cercle qui grossit.
 */
public class GrowingRenderer extends Renderer {

    private GrowingCircle circle;

    public GrowingRenderer(GrowingCircle c) {
        this.circle = c;
    }

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
