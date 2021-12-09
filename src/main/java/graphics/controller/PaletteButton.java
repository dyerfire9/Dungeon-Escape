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
     * An empty constructor for the PaletteButton class.a
     */
    public PaletteButton() { }

    /**
     * A getter method that returns the Button object underlying this PaletteButton in the FXML document
     * @return the Button object.
     */
    public Button getButton() {
        return button;
    }

    /**
     * A setter method that sets the "Element" attribute of this class.
     * @param element the Sprite for the "Element" attribute
     */
    public void setElement(EnumsForSprites element) {
        this.element = element;
    }


    /**
     * A getter method to get the Element attribute of an object of this class.
     * @return Element attribute
     */
    public EnumsForSprites getElement() {
        return element;
    }

    /**
     * A setter method that sets the "Image" attribute of this class.
     */
    public void setImage(Image img) {
        imgView.setImage(img);
    }


    /**
     * Adds a mouse-action handler to the button attribute of an object of this class.
     * @param handler a mouse-action handler
     */
    public void addOnClicked(EventHandler<MouseEvent> handler) {
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }


    /**
     * Implements the initialize() method inherited from the FXMLController interface. This method will be called once on an implementing controller when the contents of its associated document have been completely loaded:
     */
    @Override
    public void initialize() {
        //System.out.println(this.toString() + " registered");
    }
}
