package colorswitch;

import javafx.scene.canvas.GraphicsContext;

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
                vBar.getX() - vBar.getWidth() / 3,
                canvasY - vBar.getHeight() / 3,
                vBar.getWidth(),
                vBar.getHeight());
    }
}
