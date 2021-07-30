package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'une barre verticale en dessinant un rectangle coloré sur l'écran qui bouge .
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
                vBar.getX(),
                canvasY - vBar.getHeight(),
                vBar.getWidth() / 2,
                vBar.getHeight() / 2);
   }
}