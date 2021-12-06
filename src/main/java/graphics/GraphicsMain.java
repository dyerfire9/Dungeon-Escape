package graphics;

import game.Game;
import game.GameSeeder;
import game.Serializer;
import graphics.controller.*;
import graphics.dialog.BoolDialog;
import graphics.dialog.TextDialog;
import graphics.enums.ToolMode;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utils.EnumsForSprites;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Entry point of the program.
 */
public class GraphicsMain extends Application {

    private DialogPresenter dp;
    private FXMLLoader loader;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Dependency extracted from DialogPresenter
        BoolDialog bd = new BoolDialog("User save state detected. Would you like" +
                " to load it?");
        TextDialog td = new TextDialog("Please enter the size of the board.");

        dp = new DialogPresenter(bd, td);
        dp.addPropertyChangeListener(evt -> {
            String propertyName = evt.getPropertyName();
            if (propertyName.equals("done")) {
                try {
                    this.onDialogsPresented(primaryStage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        dp.present();
    }

    // Assume dp is not null
    private void onDialogsPresented(Stage primaryStage) throws IOException {
        primaryStage.setTitle("1190");
        primaryStage.setResizable(true);

        Game game;
        if (dp.requestedLoadFromSave()) {
            game = Serializer.deserialize();
        } else {
            game = new Game(dp.getRequestedBoardSize());
        }

        loader = new FXMLLoader(getClass().getResource("/fxml/renderPane.fxml"));
        // Controller set manually since a no-arg constructor is not feasible,
        // therefore FXML cannot autoinitialize this class.
        loader.setController(new RenderPane(game));
        Parent renderPaneRoot = loader.load();
        RenderPane renderPane = loader.getController();

        // Load each FXML sub-scene (voodoo magic)
        loader = new FXMLLoader(getClass().getResource("/fxml/editor.fxml"));
        Parent editorRoot = loader.load();
        Editor editor = loader.getController();
        editor.hide();

        loader = new FXMLLoader(getClass().getResource("/fxml/playSave.fxml"));
        Parent playSaveRoot = loader.load();
        PlaySave playSave = loader.getController();

        // Load main FXML scene, assemble pieces together.
        loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent mainRoot = loader.load();
        MainScene mainScene = loader.getController();
        mainScene.assemble(renderPaneRoot, playSaveRoot, editorRoot);

        // Start the game
        renderPane.start();

        addElementsToEditor(editor);
        registerActions(playSave, editor, renderPane);

        // Display GUI
        primaryStage.setScene(new Scene(mainRoot));
        primaryStage.show();
    }

    /**
     * Registers different elements to a given editor palette. To add a new element,
     * edit the implementation to make another call to addPaletteButton().
     * @param ed The given editor.
     * @throws IOException If any error occurs when reading sprite files.
     */
    private static void addElementsToEditor(Editor ed) throws IOException {
        ed.addPaletteButton(EnumsForSprites.ALLIGATOR_DEN_LEFT,
                new Image("file:src/main/assets/tiles/dngn_entrance.png"));
        ed.addPaletteButton(EnumsForSprites.ALLIGATOR_DEN_RIGHT,
                new Image("file:src/main/assets/tiles/dngn_entrance.png"));
        ed.addPaletteButton(EnumsForSprites.ALLIGATOR_DEN_DOWN,
                new Image("file:src/main/assets/tiles/dngn_entrance.png"));
        ed.addPaletteButton(EnumsForSprites.ALLIGATOR_DEN_UP,
                new Image("file:src/main/assets/tiles/dngn_entrance.png"));
        ed.addPaletteButton(EnumsForSprites.GOAL,
                new Image("file:src/main/assets/player/statues/guardian-eyeopen-flame3.png"));
        ed.addPaletteButton(EnumsForSprites.CHASER,
                new Image("file:src/main/assets/player/nonliving/molten_gargoyle.png"));
        ed.addPaletteButton(EnumsForSprites.PORTAL,
                new Image("file:src/main/assets/tiles/dngn_portal.png"));
        ed.addPaletteButton(EnumsForSprites.ROCK,
                new Image("file:src/main/assets/tiles/crystal_floor5.png"));
    }

    // Hooks up events to actions.
    private void registerActions(PlaySave playSave, Editor editor, RenderPane renderPane) {
        for (PaletteButton pb : editor.getButtons()) {
            pb.addOnClicked(event -> {
                renderPane.setElement(pb.getElement());
            });
        }

        playSave.addOnClickedPlay(event -> {
            if (playSave.isInPlayMode()) {
                renderPane.start();
                editor.hide();
            } else {
                renderPane.resetGameToBaseState();
                renderPane.stop();
                editor.show();
            }
        });

        //TODO: Fix bug where AlligatorFactory is out of sync.
        //Temp fix is to reset game state on save.
        playSave.addOnClickedSave(event -> {
            Serializer.serialize(renderPane.getGame());
        });

        editor.addOnClickedAddTool(event -> {
            renderPane.setToolMode(ToolMode.PLACE);
        });
        editor.addOnClickedDeleteTool(event -> {
            renderPane.setToolMode(ToolMode.DELETE);
        });

    }

}
