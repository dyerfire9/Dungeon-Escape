package graphics.controller;

import graphics.enums.ToolMode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.EnumsForSprites;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller class for the game's editor pane. This pane contains tool buttons for placing and deleting
 * and a "palette" of buttons representing elements that the user can select to place.
 */
public class Editor implements FXMLController {

    @FXML
    private Pane root;
    @FXML
    private VBox vbox;
    @FXML
    private Button addTool;
    @FXML
    private Button deleteTool;

    private EnumsForSprites selectedElement = EnumsForSprites.GOAL;
    private ToolMode toolMode = ToolMode.PLACE;
    private ArrayList<PaletteButton> buttons;

    /**
     * Creates a new instance by attaching it to an existing scene.
     */
    public Editor() {
        buttons = new ArrayList<>();
    }

    @Override
    public void initialize() {
        System.out.println("Editor initialized");
        addTool.setOnMouseClicked(event -> toolMode = ToolMode.PLACE);
        deleteTool.setOnMouseClicked(event -> toolMode = ToolMode.DELETE);
    }

    /**
     * Adds a new button to the editor's palette.
     * @param image The image displayed on the new button.
     * @throws IOException If there was an error in creating the new button, likely due to
     *      loading the FXML template.
     */
    public void addPaletteButton(EnumsForSprites element, Image image) throws IOException {
        PaletteButton pb = new PaletteButton(element, image);
        pb.setOnClicked(event -> this.selectedElement = pb.getElement());
        buttons.add(pb);
        vbox.getChildren().add(pb.getButton());
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

    public Pane getRoot() {
        return root;
    }

    /**
     * Gets the currently selected palette element.
     * @return The selected palette element, as an enum.
     */
    public EnumsForSprites getSelectedElement() {
        return selectedElement;
    }

    /**
     * Gets the currently selected tool mode.
     * @return The selected tool mode, as an enum.
     */
    public ToolMode getToolMode() {
        return toolMode;
    }
}
