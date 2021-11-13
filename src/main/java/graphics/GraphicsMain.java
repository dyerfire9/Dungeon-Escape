package graphics;

import game.Game;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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

        // TODO: Remove after testing
        this.addGoal(new Point2D(17, 17));
        this.addUpAlligatorDen(new Point2D(12, 13));
        this.addRightAlligatorDen(new Point2D(7,8));

        renderPane.start();

        // Show stage
        mainStage.show();
    }

    /*private static void addObject(Element object){
        renderPane.getGame().getBoard().getObjectManager().addObject(object);
    }*/

    // Object-specific add methods to be called by gameMaker
    // TODO: add more or configure with gameMaker
    public void addGoal(Point2D pos) {
        renderPane.getGame().getBoard().getObjectManager().addGoal(pos);
    }

    public void addRightAlligatorDen(Point2D pos) {
        renderPane.getGame().getBoard().getObjectManager().addRightAlligatorDen(pos);
    }
    public void addLeftAlligatorDen(Point2D pos) {
        renderPane.getGame().getBoard().getObjectManager().addLeftAlligatorDen(pos);
    }
    public void addUpAlligatorDen(Point2D pos) {
        renderPane.getGame().getBoard().getObjectManager().addUpAlligatorDen(pos);
    }
    public void addDownAlligatorDen(Point2D pos) {
        renderPane.getGame().getBoard().getObjectManager().addDownAlligatorDen(pos);
    }


}
