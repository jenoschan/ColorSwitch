package colorswitch;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;
import java.sql.Time;

public class AnimationRenderer extends Renderer {

    private Image img;
    private Entity entity;
    private String prefix;
    private int number;
    private double framerate;

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

//        context.drawImage(img, x - entity.getWidth() / 2, y - entity.getHeight() / 2, entity.getWidth(), entity.getHeight());

        javafx.scene.image.Image[] frames = new javafx.scene.image.Image[]{
                new javafx.scene.image.Image("/mushroom_animation1.png"),
                new javafx.scene.image.Image("/mushroom_animation2.png"),
                new javafx.scene.image.Image("/mushroom_animation3.png"),
                new javafx.scene.image.Image("/mushroom_animation4.png"),
                new javafx.scene.image.Image("/mushroom_animation5.png"),
                new javafx.scene.image.Image("/mushroom_animation6.png"),
                new javafx.scene.image.Image("/mushroom_animation7.png"),
                new javafx.scene.image.Image("/mushroom_animation8.png"),
                new javafx.scene.image.Image("/mushroom_animation9.png"),
                new javafx.scene.image.Image("/mushroom_animation10.png"),
                new javafx.scene.image.Image("/mushroom_animation11.png"),
                new javafx.scene.image.Image("/mushroom_animation12.png"),
                new javafx.scene.image.Image("/mushroom_animation13.png"),
                new javafx.scene.image.Image("/mushroom_animation14.png"),
                new javafx.scene.image.Image("/mushroom_animation15.png"),
                new javafx.scene.image.Image("/mushroom_animation16.png"),
                new javafx.scene.image.Image("/mushroom_animation17.png"),
                new javafx.scene.image.Image("/mushroom_animation18.png"),
                new javafx.scene.image.Image("/mushroom_animation19.png"),
                new javafx.scene.image.Image("/mushroom_animation20.png"),
                new javafx.scene.image.Image("/mushroom_animation21.png"),
                new javafx.scene.image.Image("/mushroom_animation22.png"),
                new javafx.scene.image.Image("/mushroom_animation23.png"),
                new javafx.scene.image.Image("/mushroom_animation24.png"),
                new javafx.scene.image.Image("/mushroom_animation25.png"),
                new javafx.scene.image.Image("/mushroom_animation26.png"),


        };

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

                javafx.scene.image.Image img = frames[frame % number];

                context.clearRect(x - entity.getWidth() / 2, y - entity.getHeight() / 2, entity.getWidth(), entity.getHeight());
                context.drawImage(img, x - entity.getWidth() / 2, y - entity.getHeight() / 2, entity.getWidth(), entity.getHeight());
            }
        };
        timer.start();

    }
}
