package graphics;

import graphics.controller.RenderPane;
import graphics.dialog.BoolDialog;
import graphics.dialog.TextDialog;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Separate main file, only to be used for the graphics branch.
 */
public class GraphicsMain extends Application {

    private DialogPresenter dp;
    private RenderPane renderPane;
    private int boardSize;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) throws IOException {
        // Dependency extracted from DialogPresenter
        BoolDialog bd = new BoolDialog("User save state detected. Would you like" +
                " to load it?");
        TextDialog td = new TextDialog("Please enter the size of the board.");

        dp = new DialogPresenter(bd, td);
        dp.addPropertyChangeListener(evt -> {
            String propertyName = evt.getPropertyName();
            if (propertyName.equals("done")) {
                try {
                    this.onDialogsPresented(mainStage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        dp.present();
    }

    // Essentially "does everything else" after the dialogs are finished presenting.
    //TODO: Bloated method, extract some code from it
    private void onDialogsPresented(Stage mainStage) throws IOException {

//        this.boardSize = dp.getRequestedBoardSize();
//
//        mainStage.setTitle("1190");
//        mainStage.setResizable(true);
//
//        // Init RenderPane and add to scene graph
//        if (dp.requestedLoadFromSave()) {
//            Game g = Serializer.deserialize();
//            int size = g.getSize();
//            renderPane = new RenderPane(g, new Point2D(32 * size,
//                    32 * size));
//        }
//        else {
//            renderPane = new RenderPane(new Game(this.boardSize), new Point2D(32 * this.boardSize,
//                    32 * this.boardSize));
//        }
//        renderPane.start();
//
//        // Load main scene using FXML
//        // NOTE: This method of loading resources may not work when packaged as a JAR
//        URL url = new File("src/main/assets/main.fxml").toURI().toURL();
//        Scene fxmlScene = new Scene(FXMLLoader.load(url));
//        mainStage.setScene(fxmlScene);
//
//        ScrollPane sp = (ScrollPane) fxmlScene.lookup("#renderPaneParent");
//        sp.setContent(renderPane.getCanvas());
//
//        Editor editor = new Editor();
//        Image img = new Image("file:src/main/assets/player/animals/alligator.png");
//        editor.addPaletteButton(EnumsForSprites.ALLIGATOR, img);
//
//        Button playButton = (Button) fxmlScene.lookup("#playButton");
//        PlayButtonController pbc = new PlayButtonController(playButton);
//        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
//            renderPane.changeGameState();
//            if (renderPane.isMakeMode()) {
//                editor.show();
//            } else {
//                editor.hide();
//            }
//        });
//
//        Button saveButton = (Button) fxmlScene.lookup("#saveButton");
//        saveButton.setOnMouseClicked(event -> {
//            renderPane.resetObjectsToBaseState();
//            Serializer.serialize(renderPane.getGame());
//        });

        // Show stage
        mainStage.show();
    }
}
