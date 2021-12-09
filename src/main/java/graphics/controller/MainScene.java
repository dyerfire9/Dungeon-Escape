package graphics.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

public class MainScene implements FXMLController {

    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane renderPane;
    @FXML
    private AnchorPane playSave;
    @FXML
    private AnchorPane editor;

    /**
     * Empty constructor. The method intentionally has no arguments so that FXMLLoader can properly set its
     * instance variables.
     */
    public MainScene() { }

    @Override
    public void initialize() {
        System.out.println("MainScene initialized");
    }

    /**
     * Sets FXML nodes to their respective parents in the main scene
     * @param renderPane the renderPane node
     * @param playSave the playSave node
     * @param editor the editor node
     */
    public void assemble(Node renderPane, Node playSave, Node editor) {
        this.renderPane.getChildren().add(renderPane);
        AnchorPane.setLeftAnchor(this.renderPane, 0.0);
        AnchorPane.setRightAnchor(this.renderPane, 0.0);
        AnchorPane.setTopAnchor(this.renderPane, 0.0);
        AnchorPane.setBottomAnchor(this.renderPane, 0.0);
        this.playSave.getChildren().add(playSave);
        this.editor.getChildren().add(editor);
        AnchorPane.setTopAnchor(this.editor, 0.0);
        AnchorPane.setBottomAnchor(this.editor, 0.0);
    }

    /**
     * Returns the root node of this scene.
     * @return The root node.
     */
    public AnchorPane getRoot() {
        return root;
    }
}
