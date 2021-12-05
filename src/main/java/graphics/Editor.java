package graphics;

import graphics.enums.ToolMode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import utils.EnumsForSprites;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Editor {
    private static final File TEMPLATE = new File("src/main/assets/main.fxml");

    private EnumsForSprites selectedElement;
    private ToolMode toolMode;
    private ScrollPane root;
    private PaletteButton template;

    public Editor() throws IOException {
        URL url = TEMPLATE.toURI().toURL();
        Scene sc = new Scene(FXMLLoader.load(url));
        root = (ScrollPane) sc.lookup("#editor");

        Button button = (Button) sc.lookup("#templateButton");
        ImageView imgView = (ImageView) sc.lookup("#templateButtonImg");
    }

    /**
     * Makes the editor invisible.
     */
    public void hide() {
        root.setVisible(false);
    }

    /**
     * Makes the editor visible.
     */
    public void show() {
        root.setVisible(true);
    }
}
