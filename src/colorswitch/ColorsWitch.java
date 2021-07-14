package colorswitch;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

/**
 * Classe principale. Définit la vue.
 */
public class ColorsWitch extends Application {

    public static final double WIDTH = 320, HEIGHT = 480;

    private Controller controller;
    private GraphicsContext context;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Pane root = new Pane(canvas);

        context = canvas.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = System.nanoTime();

            @Override
            public void handle(long now) {
                controller.tick((now - lastTime) * 1e-9);

                context.setFill(Color.BLACK);
                context.fillRect(0, 0, WIDTH, HEIGHT);

                List<Entity> entities = controller.getEntities();

                for (Entity e : entities) {
                    e.getRepresentation().draw(controller.getCurrentLevel(), context);
                }

                lastTime = now;
            }
        };
        timer.start();

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        scene.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.SPACE) {
                controller.spaceTyped();
            }
            if (event.getCode() == KeyCode.TAB){
                controller.tabTyped();
            }
        });

        primaryStage.setTitle("Colors Witch");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
