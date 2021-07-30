package colorswitch;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.List;



/**
 * Classe principale. Définit la vue.
 */
public class ColorsWitch extends Application {

    public static final double WIDTH = 320, HEIGHT = 480;
    private static GraphicsContext context;

    private Controller controller;
    private int tab = 0;
    String labelName;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Menu
        Label label = new Label("COLORS WITCH");
        label.setTextFill(Color.WHITE);
        label.setFont((Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR,30)));
        Button startButton = new Button("Start game");

        VBox layout1 = new VBox(20);
        layout1.setAlignment(Pos.CENTER);
        layout1.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        //Level display
        HBox levelChoices = new HBox(10);
        Label level1 = new Label("1");
        Label level2 = new Label("2");
        Label level3 = new Label("3");
        Label level4 = new Label("4");
        Label level5 = new Label("5");
        Label level6 = new Label("6");
        Label level7 = new Label("7");
        Label level8 = new Label("8");
        Label level9 = new Label("9");
        Label level10 = new Label("10");
        level1.setTextFill(Color.WHITE);
        level2.setTextFill(Color.WHITE);
        level3.setTextFill(Color.WHITE);
        level4.setTextFill(Color.WHITE);
        level5.setTextFill(Color.WHITE);
        level6.setTextFill(Color.WHITE);
        level7.setTextFill(Color.WHITE);
        level8.setTextFill(Color.WHITE);
        level9.setTextFill(Color.WHITE);
        level10.setTextFill(Color.WHITE);


        levelChoices.getChildren().addAll(level1,level2,level3,level4,level5,level6,level7,level8,level9,level10);
        levelChoices.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(label,levelChoices,startButton);
        Scene scene1 = new Scene(layout1,WIDTH,HEIGHT);

        // Game view - Scene2
        controller = new Controller();

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Pane root = new Pane(canvas);

        context = canvas.getGraphicsContext2D();
        context.setFill(Color.BLACK);

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

        Scene scene2 = new Scene(root, WIDTH, HEIGHT);

        scene2.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.SPACE) {
                controller.spaceTyped();
            }
            if (event.getCode() == KeyCode.TAB){
                if (tab == 1){
                    controller.tabTypedTwo();
                    tab = 0;
                } else{
                    tab = 1;
                    controller.tabTyped();
                }
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.setScene(scene1);
            }
        });

        scene1.setOnKeyPressed((event) ->{
            if (event.getCode() == KeyCode.ESCAPE) {
                System.exit(0);
            }
        });

        //Start Game
        startButton.setOnAction(e-> primaryStage.setScene(scene2));

        //onclick -> Goes to x level
        level1.setOnMouseClicked(e -> {controller.setLevel(new Level1(ColorsWitch.WIDTH, ColorsWitch.HEIGHT));
                                    primaryStage.setScene(scene2);});
        level2.setOnMouseClicked(e -> {controller.setLevel(new Level2(ColorsWitch.WIDTH, ColorsWitch.HEIGHT));
                                    primaryStage.setScene(scene2);});
        level3.setOnMouseClicked(e -> {controller.setLevel(new Level3(ColorsWitch.WIDTH, ColorsWitch.HEIGHT));
                                    primaryStage.setScene(scene2);});
        level4.setOnMouseClicked(e -> {controller.setLevel(new Level4(ColorsWitch.WIDTH, ColorsWitch.HEIGHT));
                                    primaryStage.setScene(scene2);});
        level5.setOnMouseClicked(e -> {controller.setLevel(new Level5(ColorsWitch.WIDTH, ColorsWitch.HEIGHT));
                                    primaryStage.setScene(scene2);});
        level6.setOnMouseClicked(e -> {controller.setLevel(new Level6(ColorsWitch.WIDTH, ColorsWitch.HEIGHT));
                                    primaryStage.setScene(scene2);});
        level7.setOnMouseClicked(e -> {controller.setLevel(new Level7(ColorsWitch.WIDTH, ColorsWitch.HEIGHT));
                                    primaryStage.setScene(scene2);});
        level8.setOnMouseClicked(e -> {controller.setLevel(new Level8(ColorsWitch.WIDTH, ColorsWitch.HEIGHT));
                                    primaryStage.setScene(scene2);});
        level9.setOnMouseClicked(e -> {controller.setLevel(new Level9(ColorsWitch.WIDTH, ColorsWitch.HEIGHT));
                                    primaryStage.setScene(scene2);});
        level10.setOnMouseClicked(e -> {controller.setLevel(new Level10(ColorsWitch.WIDTH, ColorsWitch.HEIGHT));
                                    primaryStage.setScene(scene2);});

        primaryStage.setTitle("Colors Witch");
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
