package graphics;

import game.Game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashSet;
import graphics.GraphicsLoader;
import utils.Point2D;

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
    private static Game game;

    //TODO: Move these attributes somewhere else later
    //TODO: Make class structure cleaner. Everything is static and a bit of a mess
    private static KeyboardReader playerKeyReader;

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
        // Allows for listening of keyboard events. Must be called after the node is added to scene graph
        canvas.requestFocus();

        // Init GraphicsContext and GraphicsLoader
        gc = canvas.getGraphicsContext2D();

        // Init KeyboardListener
        playerKeyReader = new KeyboardReader(canvas);
        playerKeyReader.addKeyListeners();


        /* GAME-RELATED SETUP */
        gl = new GraphicsLoader();
        game = new Game(20);



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
        movePlayer();
        game.updateBoard();
        game.updatePlayerState();
        gl.drawBoard(gc, game);
        gl.drawPlayer(gc, game);
        drawDebugInfo(deltaTime / 1000000000.0, 0, 0);
        gl.drawPlayerState(gc, new Point2D(32*16, 32), game);
    }

    private static void movePlayer() {
        if (playerKeyReader.getActiveKeys().contains("W")) {
            game.movePlayer(new Point2D(0, -1));
            playerKeyReader.getActiveKeys().remove("W");
        }
        if (playerKeyReader.getActiveKeys().contains("A")) {
            game.movePlayer(new Point2D(-1, 0));
            playerKeyReader.getActiveKeys().remove("A");
        }
        if (playerKeyReader.getActiveKeys().contains("S")) {
            game.movePlayer(new Point2D(0, 1));
            playerKeyReader.getActiveKeys().remove("S");
        }
        if (playerKeyReader.getActiveKeys().contains("D")) {
            game.movePlayer(new Point2D(1, 0));
            playerKeyReader.getActiveKeys().remove("D");
        }
    }

    /**
     * Renders various debug info at (x, y) to be displayed in real-time.
     * Can be modified in the future to add more debug info.
     * @param deltaTimeSec Time elapsed since last frame, in seconds.
     * @param x Horizontal screen position.
     * @param y Vertical screen position.
     */
    private static void drawDebugInfo(double deltaTimeSec, double x, double y) {
        Font debugFont = new Font("Consolas", 12);
        gc.setFont(debugFont);
        gc.setFill(Color.MAGENTA);
        gc.fillText(String.format("FPS: %.1f", 1 / deltaTimeSec), x, y + 12);
        gc.fillText(String.format("PressedKeys: %s", playerKeyReader.getPressedKeys().toString()), x, y + 24);
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
