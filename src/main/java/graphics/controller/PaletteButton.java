package graphics.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import utils.EnumsForSprites;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PaletteButton implements FXMLController {

    @FXML
    private ImageView imgView;
    @FXML
    private Button button;

    private EnumsForSprites element;

    /**
     * An empty constructor for the PallettButton class.
     */
    public PaletteButton() { }

    /**
     * A getter method that returns the Button object.
     * @return the Button object.
     */
    public Button getButton() {
        return button;
    }

    public void setElement(EnumsForSprites element) {
        this.element = element;
    }

    public EnumsForSprites getElement() {
        return element;
    }

    public void setImage(Image img) {
        imgView.setImage(img);
    }

    public void addOnClicked(EventHandler<MouseEvent> handler) {
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    @Override
    public void initialize() {
        //System.out.println(this.toString() + " registered");
    }
}
