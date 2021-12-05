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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utils.EnumsForSprites;

import java.io.IOException;


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

        // Start the game
        renderPane.start();

        addElementsToEditor(editor);

        Scene gameScene = new Scene(mainRoot);

        // Display GUI
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    public static void addElementsToEditor(Editor ed) throws IOException {
        ed.addPaletteButton(EnumsForSprites.PLAYER,
                new Image("file:src/main/assets/player/deep_elf_blademaster.png"));
        ed.addPaletteButton(EnumsForSprites.ALLIGATOR,
                new Image("file:src/main/assets/player/animals/alligator.png"));
        ed.addPaletteButton(EnumsForSprites.ALLIGATOR_DEN_RIGHT,
                new Image("file:src/main/assets/tiles/dngn_entrance.png"));
        ed.addPaletteButton(EnumsForSprites.GOAL,
                new Image("file:src/main/assets/player/statues/guardian-eyeopen-flame3.png"));
    }

}
