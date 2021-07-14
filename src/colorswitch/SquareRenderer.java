package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un Square en dessinant un carré coloré sur l'écran.
 */
public class SquareRenderer extends Renderer {

    private Square carre;

    public SquareRenderer(Square c) {
        this.carre = c;
    }

    @Override
    public void draw(Level level, GraphicsContext context) {

        double canvasY = Renderer.computeScreenY(level, carre.getY());

        context.setFill(Renderer.convertColor(carre.getColor()));

        context.fillRect(
                carre.getX() - carre.getWidth() / 2,
                canvasY - carre.getWidth() / 2,
                carre.getWidth(),
                carre.getWidth());
    }
}
