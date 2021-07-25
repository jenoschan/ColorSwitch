package colorswitch;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.image.Image;

import javax.swing.*;
import java.sql.Time;

public class AnimationRenderer extends Renderer {

    private Image img;
    private Entity entity;
    private String prefix;
    private int number;
    private double framerate;
    private String source;

    public AnimationRenderer(String prefix, int number, double framerate, Entity entity) {
        this.prefix = prefix;
        this.number = number;
        this.framerate = framerate;
        this.entity = entity;
    }

    @Override
    public void draw(Level level, GraphicsContext context) {

        double x = entity.getX();
        double y = Renderer.computeScreenY(level, entity.getY());

        for (int i = 1; i <= number; i++){
           source = "/"+ prefix + String.valueOf(i) + ".png";
        }

        Image[] frames = new Image[]{
                new javafx.scene.image.Image(source),
        };

        //Framerate is kinda buggy for some reason
        double frameRate = number * framerate; // 26 fps = 26*10^-9 images par nanoseconde
        AnimationTimer timer = new AnimationTimer() {
            private long startTime = 0;

            @Override
            public void handle(long now) {
                if (startTime == 0) {
                    startTime = now;
                    return;
                }

                /* Calcul du deltaTime par rapport au
                   début de l'animation */
                double deltaTime = now - startTime;
                int frame = (int) (deltaTime * frameRate);

                Image img = frames[frame % frames.length];

                //clear drawing
                context.fillRect(x - entity.getWidth()/2, y - entity.getHeight()/2, entity.getWidth(), entity.getHeight());
                context.setFill(Color.BLACK);

                //new drawing
                context.drawImage(img, x - entity.getWidth()/2 , y - entity.getHeight()/2);

            }
        };
        timer.start();

    }
}
