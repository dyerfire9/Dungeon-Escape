package game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.HashSet;

/**
 * Separate main file, only to be used for the graphics branch.
 */
public class GraphicsMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    static Scene mainScene;
    static GraphicsContext graphicsContext;

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("Event Handling");

        Group root = new Group();
        mainScene = new Scene(root);
        mainStage.setScene(mainScene);

        Canvas canvas = new Canvas(32*20, 32*20);
        root.getChildren().add(canvas);

        prepareActionHandlers();

        graphicsContext = canvas.getGraphicsContext2D();

        loadGraphics();

        /**
         * game.Main "game" loop
         */
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                tickAndRender();
            }
        }.start();

        mainStage.show();
    }

    private static void prepareActionHandlers() {

    }

    private static void loadGraphics() {

    }

//    private static String getResource(String filename) {
//        return GraphicsMain.class.getResource(filename).toString();
//    }

    private static void tickAndRender() {

    }
}
