package graphics.controller;

import graphics.enums.ToolMode;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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

    /**
     * Implements FXMLController's initialize() method
     */
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

    /**
     * Adds custom buttons to the main GUI, which, when clicked on, add different types of Elements to the game board.
     * @param element the Sprite for a type of Element object to be added
     * @param img the image for a button to add the Element
     * @throws IOException a checked exception that indicates a failure in Input & Output operations
     */
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

    /**
     * shows the main GUI
     */
    public void show() {
        root.setVisible(true);
    }

    /**
     * hides the main GUI
     */
    public void hide() {
        root.setVisible(false);
    }

    /**
     * a getter method to get the list of all custom buttons added to the main GUI
     * @return a list of buttons
     */
    public ArrayList<PaletteButton> getButtons() {
        return buttons;
    }

    public Pane getRoot() {
        return root;
    }

    /**
     * Adds a mouse-event handler to the button that switches the game mode to PLACE ELEMENT
     * @param handler a mouse-event handler
     */
    public void addOnClickedAddTool(EventHandler<MouseEvent> handler) {
        addTool.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }


    /**
     * Adds a mouse-event handler to the button that switches the game mode to DELETE ELEMENT
     * @param handler a mouse-even handler
     */
    public void addOnClickedDeleteTool(EventHandler<MouseEvent> handler) {
        deleteTool.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
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
