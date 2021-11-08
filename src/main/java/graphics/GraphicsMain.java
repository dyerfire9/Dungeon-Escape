package graphics;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.HashSet;
import graphics.GraphicsLoader;

/**
 * Separate main file, only to be used for the graphics branch.
 */
public class GraphicsMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static Scene mainScene;
    private static GraphicsContext gc;
    private static GraphicsLoader gl;

    private static final int WIDTH = 32 * 20;
    private static final int HEIGHT = 32 * 20;

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("1190");

        // Build scene graph
        Group root = new Group();
        mainScene = new Scene(root);
        mainStage.setScene(mainScene);

        // Init canvas
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        // Init GraphicsContext and GraphicsLoader
        gl = new GraphicsLoader();
        gc = canvas.getGraphicsContext2D();

        // Init KeyboardListener
        KeyboardReader keyReader = new KeyboardReader(mainScene);
        keyReader.addKeyListeners();


        // ########### Main game loop ###########
        // Init a new AnimationTimer. This contains the handle method,
        // which is called once every frame.
        new AnimationTimer() {
            // Init at -1 to indicate value has not been set by handle() method
            long nanoTime = -1;

            public void handle(long currentNanoTime) {
                if (nanoTime < 0) {
                    tickAndRender(0);
                } else {
                    tickAndRender(currentNanoTime - nanoTime);
                }
                nanoTime = currentNanoTime;
            }
        }.start();

        mainStage.show();
    }
    
    private static void tickAndRender(long deltaTime) {
        clearScreen();
        gl.drawBoard(gc);
        gl.drawPlayer(gc, 0, 0);
        drawDebugInfo(deltaTime / 1000000000.0, 0, 0);
    }

    /**
     * Renders various debug info at (x, y) to be displayed in real-time.
     * Can be modified in the future to add more debug info.
     * @param deltaTimeSec Time elapsed since last frame, in seconds.
     * @param x Horizontal screen position.
     * @param y Vertical screen position.
     */
    private static void drawDebugInfo(double deltaTimeSec, double x, double y) {
        gc.setFill(Color.MAGENTA);
        gc.fillText(String.format("FPS: %.1f", 1 / deltaTimeSec), x, y + 10);
    }

    /**
     * Clears the entire screen.
     */
    private static void clearScreen() {
        Paint oldFill = gc.getFill();

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(oldFill);
    }
}
