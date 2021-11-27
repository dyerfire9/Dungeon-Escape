package graphics;

import game.Game;
import game.Serializer;
import game.GameMaker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import utils.Point2D;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Separate main file, only to be used for the graphics branch.
 */
public class GraphicsMain extends Application {

    private static Scene mainScene;
    //NOTE: Not sure if storing RenderPane as private static is clean, but it's a temp solution at least
    private static RenderPane renderPane;
    private int boardSize;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) throws IOException {
        GameMaker gameMaker = new GameMaker();

        int[] sizeLoad  = gameMaker.getBoardSize();

        this.boardSize = sizeLoad[0];
        int load = sizeLoad[1];

        mainStage.setTitle("1190");


        // Init RenderPane and add to scene graph
        if (load == 1) {
            Game g = Serializer.deserialize();
            int size = g.getSize();
            renderPane = new RenderPane(g, new Point2D(32 * size,
                    32 * size));
        }
        else {
            renderPane = new RenderPane(new Game(this.boardSize), new Point2D(32 * this.boardSize,
                    32 * this.boardSize));
        }
        renderPane.start();

        // Load resources using FXML
        // NOTE: This method of loading resources may not work when packaged as a JAR
        URL url = new File("src/main/assets/testScene.fxml").toURI().toURL();
        Scene fxmlScene = new Scene(FXMLLoader.load(url));
        mainStage.setScene(fxmlScene);

        // TODO: Extract to another class later
        BorderPane bp = (BorderPane) fxmlScene.lookup("#layout");
        bp.setCenter(renderPane.getAnchor());
        Button playButton = (Button) fxmlScene.lookup("#playButton");
        PlayButtonController pbc = new PlayButtonController(playButton);
        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            renderPane.changeGameState();
        });
        // TODO: Extract to another class later
        Button saveButton = (Button) fxmlScene.lookup("#saveButton");
        saveButton.setOnMouseClicked(event -> {
            Serializer.serialize(renderPane.getGame());
        });

        // Show stage
        mainStage.show();
    }
}
