package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un rectangle qui bouge diagonalement".
 */
public class DiagonalRenderer extends Renderer {

    private DiagonalBar DBar;

    public DiagonalRenderer(DiagonalBar c) {
        this.DBar = c;
    }

    @Override
    public void draw(Level level, GraphicsContext context) {

        double canvasY = Renderer.computeScreenY(level, DBar.getY());

        context.setFill(Renderer.convertColor(DBar.getColor()));

        context.fillRect(
                DBar.getX(),
                canvasY - DBar.getHeight(),
                DBar.getWidth() / 2,
                DBar.getHeight() / 2);

    }

}
