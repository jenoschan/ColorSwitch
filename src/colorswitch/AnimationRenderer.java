package colorswitch;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class AnimationRenderer extends Renderer {

//    private Image img;
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

    //todo fix animation
    @Override
    public void draw(Level level, GraphicsContext context) {

        double x = entity.getX();
        double y = Renderer.computeScreenY(level, entity.getY());

        Image[] frames = new Image[number];

        for (int i = 1; i <= number; i++){
            source = "/"+ prefix + i + ".png";
        }
        String fileLocation = source;

        for (int i = 0; i < number; i++) {
                frames[i] = new Image(fileLocation);
        }

        double frameRate = number * framerate; // 26 fps = 26*10^-9 images par nanoseconde
        long startTime = 0;

        double deltaTime = System.nanoTime() - startTime;
        int frame = (int) (deltaTime * frameRate);

        Image img = frames[10];

        //clear drawing
        context.clearRect(x - entity.getWidth()/2 , y - entity.getHeight()/2, img.getWidth(), img.getHeight());
        context.setFill(Color.BLACK);

        //new drawing
        context.drawImage(img, x - entity.getWidth()/2 , y - entity.getHeight()/2);

    }
}
