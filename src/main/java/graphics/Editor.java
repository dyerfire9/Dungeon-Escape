package graphics;

import graphics.enums.ToolMode;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.EnumsForSprites;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Presenter class for the game's editor pane. This pane contains tool buttons for placing and deleting
 * and a "palette" of buttons representing elements that the user can select to place.
 */
public class Editor {

    private static final File TEMPLATE = new File("src/main/assets/main.fxml");

    private EnumsForSprites selectedElement;
    private ToolMode toolMode;
    private Pane root;
    private VBox paletteContainer;
    private Button addTool;
    private Button deleteTool;
    private ArrayList<PaletteButton> buttons;

    /**
     * Creates a new instance with default property values.
     * @throws IOException If there is an error in loading the FXML template.
     */
    public Editor() throws IOException {
        URL url = TEMPLATE.toURI().toURL();
        Scene sc = new Scene(FXMLLoader.load(url));
        root = (Pane) sc.lookup("#editor");
        addTool = (Button) sc.lookup("#addToolButton");
        deleteTool = (Button) sc.lookup("#deleteToolButton");
        paletteContainer = (VBox) sc.lookup("palette");
        buttons = new ArrayList<>();
    }

    /**
     * Adds a new button to the editor's palette.
     * @param image The image displayed on the new button.
     * @param handler The listener that is fired when the button is clicked.
     * @throws IOException If there was an error in creating the new button, likely due to
     *      loading the FXML template.
     */
    public void addPaletteButton(Image image, EventHandler<MouseEvent> handler) throws IOException {
        PaletteButton pb = new PaletteButton(image);
        pb.setOnClicked(handler);
        buttons.add(pb);
        paletteContainer.getChildren().add(pb.getButton());
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

    /**
     * Gets the selected palette element.
     * @return
     */
    public EnumsForSprites getSelectedElement() {
        return selectedElement;
    }

    public void setSelectedElement(EnumsForSprites selectedElement) {
        this.selectedElement = selectedElement;
    }

    public ToolMode getToolMode() {
        return toolMode;
    }

    public void setToolMode(ToolMode toolMode) {
        this.toolMode = toolMode;
    }
}
