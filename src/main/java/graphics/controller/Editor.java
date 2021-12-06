package graphics.controller;

import graphics.enums.ToolMode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
        addTool.setOnMouseClicked(event -> {
            toolMode = ToolMode.PLACE;
            System.out.printf("[Editor] Switched tool mode to '%s'. %n", toolMode);
        });
        deleteTool.setOnMouseClicked(event -> {
            toolMode = ToolMode.DELETE;
            System.out.printf("[Editor] Switched tool mode to '%s'. %n", toolMode);
        });
    }

    public void addPaletteButton(EnumsForSprites element, Image img) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/paletteButton.fxml"));
        loader.load();
        PaletteButton paletteButton = loader.getController();
        paletteButton.setElement(element);
        paletteButton.setImage(img);
        paletteButton.addOnClicked(event -> {
            this.selectedElement = element;
            System.out.printf("[Editor] Switched palette element to '%s'. %n", element);
        });

        buttons.add(paletteButton);
        vbox.getChildren().add(paletteButton.getButton());
    }

    public ArrayList<PaletteButton> getButtons() {
        return buttons;
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
