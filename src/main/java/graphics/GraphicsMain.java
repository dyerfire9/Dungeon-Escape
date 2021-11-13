package graphics;

import elements.Element;
import game.Game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import utils.Point2D;

/**
 * Separate main file, only to be used for the graphics branch.
 */
public class GraphicsMain extends Application {

    private static Scene mainScene;
    //NOTE: Not sure if storing RenderPane as private static is clean, but it's a temp solution at least
    private static RenderPane renderPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("1190");

        // Build scene graph
        Group root = new Group();
        mainScene = new Scene(root);
        mainStage.setScene(mainScene);

        // Init RenderPane and add to scene graph
        renderPane = new RenderPane(new Game(20), new Point2D(32 * 20, 32 * 20));
        root.getChildren().add(renderPane.getAnchor());
        renderPane.start();

        // Show stage
        mainStage.show();
    }

    private static void addObject(Element object){
        renderPane.getGame().getBoard().getObjectStateManager().addObject(object);
    }
}
