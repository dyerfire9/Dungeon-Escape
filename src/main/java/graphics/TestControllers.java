package graphics;

import game.Game;
import graphics.controller.Editor;
import graphics.controller.MainScene;
import graphics.controller.PlaySave;
import graphics.controller.RenderPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestControllers extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Game game = new Game(20);

        // Load each FXML sub-scene (voodoo magic)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/editor.fxml"));
        Parent editorRoot = loader.load();
        Editor editor = loader.getController();

        loader = new FXMLLoader(getClass().getResource("/fxml/playSave.fxml"));
        Parent playSaveRoot = loader.load();
        PlaySave playSave = loader.getController();

        loader = new FXMLLoader(getClass().getResource("/fxml/renderPane.fxml"));
        // Controller set manually since a no-arg constructor is not feasible,
        // therefore FXML cannot autoinitialize this class.
        loader.setController(new RenderPane(game));
        Parent renderPaneRoot = loader.load();
        RenderPane renderPane = loader.getController();

        // Load main FXML scene, assemble pieces together.
        loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent mainRoot = loader.load();
        MainScene mainScene = loader.getController();
        mainScene.assemble(renderPaneRoot, playSaveRoot, editorRoot);

        renderPane.start();

        // Display GUI
        primaryStage.setScene(new Scene(mainRoot));
        primaryStage.show();
    }

}
