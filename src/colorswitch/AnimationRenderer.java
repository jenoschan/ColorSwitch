package colorswitch;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class AnimationRenderer extends Renderer{

    private String prefix;
    private int number;
    private double framerate;
    private Entity entity;

    public AnimationRenderer(String prefix, int number, double framerate, Entity entity) {
        this.prefix = prefix;
        this.number = number;
        this.framerate = framerate;
        this.entity = entity;

        Image[] frames = new Image[]{
                new Image("/mushroom_animation1.png"),
                new Image("/mushroom_animation2.png"),
                new Image("/mushroom_animation3.png"),
                new Image("/mushroom_animation4.png"),
                new Image("/mushroom_animation5.png"),
                new Image("/mushroom_animation6.png"),
                new Image("/mushroom_animation7.png"),
                new Image("/mushroom_animation8.png"),
                new Image("/mushroom_animation9.png"),
                new Image("/mushroom_animation10.png"),
                new Image("/mushroom_animation11.png"),
                new Image("/mushroom_animation12.png"),
                new Image("/mushroom_animation13.png"),
                new Image("/mushroom_animation14.png"),
                new Image("/mushroom_animation15.png"),
                new Image("/mushroom_animation16.png"),
                new Image("/mushroom_animation17.png"),
                new Image("/mushroom_animation18.png"),
                new Image("/mushroom_animation19.png"),
                new Image("/mushroom_animation20.png"),
                new Image("/mushroom_animation21.png"),
                new Image("/mushroom_animation22.png"),
                new Image("/mushroom_animation23.png"),
                new Image("/mushroom_animation24.png"),
                new Image("/mushroom_animation25.png"),
                new Image("/mushroom_animation26.png"),
        };

    }

    @Override
    public void draw(Level level, GraphicsContext context) {
        //todo
    }
}
