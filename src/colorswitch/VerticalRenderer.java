package colorswitch;


import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import javax.naming.spi.InitialContextFactoryBuilder;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Fait le rendu d'une barre vertical en dessinant un rectangle coloré sur l'écran qui bouge .
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

//public class VerticalRenderer extends Renderer {
//
//    private Entity entity;
//
//    public VerticalRenderer(Entity entity){
//        this.entity = entity;
//    }
//
//    @FXML
//    private ImageView vBar;
//
//    @Override
//    public void draw(Level level, GraphicsContext context) {
//
//        TranslateTransition translate = new TranslateTransition();
//        translate.setNode(vBar);
//        translate.setDuration(Duration.millis(200));
//        translate.setByX(350);
//        translate.play();
//
//    }
//
//}
