package graphics.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

public class MainScene implements FXMLController {

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

    public void assemble(Node renderPane, Node playSave, Node editor) {
        this.renderPane.getChildren().add(renderPane);
        this.playSave.getChildren().add(playSave);
        this.editor.getChildren().add(editor);
    }
}
