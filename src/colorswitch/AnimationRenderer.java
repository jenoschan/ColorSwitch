package colorswitch;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Fait le rendu du Mushroom sur l'écran
 */

public class AnimationRenderer extends Renderer {

    /**
     * On initialise les différentes variables
     */
    private Image img;
    private Entity entity;
    private String prefix;
    private int number;
    private double framerate;

    private double lastTime = System.nanoTime();

    /**
     *
     * @param prefix Prefixe de l'image à render
     * @param number Numéro de l'image à render
     * @param framerate Framerate de diffusion
     * @param entity Item à render
     */
    public AnimationRenderer(String prefix, int number, double framerate, Entity entity) {
        this.img = new Image(prefix + number + ".png");
        this.prefix = prefix;
        this.number = number;
        this.framerate = framerate;
        this.entity = entity;
    }

    @Override

    /**
     * Fonction qui dessine l'entité
     */
    public void draw(Level level, GraphicsContext context) {

        double x = this.entity.getX();
        double y = Renderer.computeScreenY(level, this.entity.getY());

        double time = System.nanoTime();
        double deltaTime = (time - this.lastTime) * 1e-9;

        if(deltaTime <= 1.0/framerate){
            this.number = (this.number + 1) % 26;
            this.img = new Image("/" + this.prefix + (this.number + 1) + ".png");
            this.lastTime = time;
        }

        //new drawing
        context.drawImage(this.img, x - this.entity.getWidth()/2 , y - this.entity.getHeight()/2);

    }
}
