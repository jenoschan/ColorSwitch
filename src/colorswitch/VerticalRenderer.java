package colorswitch;


import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 * Fait le rendu d'un Square en dessinant un carré coloré sur l'écran.
 */
public class VerticalRenderer extends Renderer {

    private VerticalBar vBar;

    public VerticalRenderer(VerticalBar vBar) {
        this.vBar = vBar;
    }

    @Override
    public void draw(Level level, GraphicsContext context) {

        double canvasY = Renderer.computeScreenY(level, vBar.getY());

        context.setFill(Renderer.convertColor(vBar.getColor()));

        context.fillRect(
                vBar.getX() - vBar.getWidth() / 4,
                canvasY - vBar.getHeight(),
                vBar.getWidth() / 2,
                vBar.getHeight() / 2);

    }

}
