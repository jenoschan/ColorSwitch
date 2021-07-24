package colorswitch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.sql.Time;


public class AnimationRenderer extends Renderer {

    private String prefix;
    private int number;
    private double framerate;
    private Entity entity;

    private Group mushroom;

    public AnimationRenderer(String prefix, int number, double framerate, Entity entity) {
        this.prefix = prefix;
        this.number = number;
        this.framerate = framerate;
        this.entity = entity;

    }

    @Override
    public void draw(Level level, GraphicsContext context) {

        final ImageView mush1 = new ImageView("/mushroom_animation1.png");
        final ImageView mush2 = new ImageView("/mushroom_animation2.png");
        final ImageView mush3 = new ImageView("/mushroom_animation3.png");
        final ImageView mush4 =new ImageView("/mushroom_animation4.png");
        final ImageView mush5 =new ImageView("/mushroom_animation5.png");
        final ImageView mush6 =new ImageView("/mushroom_animation6.png");
        final ImageView mush7 =new ImageView("/mushroom_animation7.png");
        final ImageView mush8 =new ImageView("/mushroom_animation8.png");
        final ImageView mush9 =new ImageView("/mushroom_animation9.png");
        final ImageView mush10 =new ImageView("/mushroom_animation10.png");
        final ImageView mush11 =new ImageView("/mushroom_animation11.png");
        final ImageView mush12 =new ImageView("/mushroom_animation12.png");
        final ImageView mush13 =new ImageView("/mushroom_animation13.png");
        final ImageView mush14 = new ImageView("/mushroom_animation14.png");
        final ImageView mush15 = new ImageView("/mushroom_animation15.png");
        final ImageView mush16 = new ImageView("/mushroom_animation16.png");
        final ImageView mush17 = new ImageView("/mushroom_animation17.png");
        final ImageView mush18 = new ImageView("/mushroom_animation18.png");
        final ImageView mush19 = new ImageView("/mushroom_animation19.png");
        final ImageView mush20 = new ImageView("/mushroom_animation20.png");
        final ImageView mush21 = new ImageView("/mushroom_animation21.png");
        final ImageView mush22 = new ImageView("/mushroom_animation22.png");
        final ImageView mush23 = new ImageView("/mushroom_animation23.png");
        final ImageView mush24 = new ImageView("/mushroom_animation24.png");
        final ImageView mush25 = new ImageView("/mushroom_animation25.png");
        final ImageView mush26 = new ImageView("/mushroom_animation26.png");

        mushroom = new Group(mush1);

        mushroom.setTranslateY(Renderer.computeScreenY(level, entity.getY()));

        Timeline t = new Timeline();
        t.setCycleCount(Timeline.INDEFINITE);

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),
                (ActionEvent event)->{
                    mushroom.getChildren().setAll(mush2);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(300),
                (ActionEvent event)->{
                    mushroom.getChildren().setAll(mush3);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(400),
                (ActionEvent event)->{
                    mushroom.getChildren().setAll(mush4);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(500),
                (ActionEvent event)->{
                    mushroom.getChildren().setAll(mush5);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(600),
                (ActionEvent event)->{
                    mushroom.getChildren().setAll(mush6);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(700),
                (ActionEvent event)->{
                    mushroom.getChildren().setAll(mush7);
                }
        ));

    }

}
