package colorswitch;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

/**
 * Fait le rendu d'un Cercle qui rotate".
 */
public class RotatingRenderer extends Renderer {

    private RotatingCircle circle;

    public RotatingRenderer(RotatingCircle c) {
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
