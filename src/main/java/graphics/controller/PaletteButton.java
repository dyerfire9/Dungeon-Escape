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

public class PaletteButton {

    @FXML
    private ImageView imageView;
    @FXML
    private Button button;

    private static final File TEMPLATE = new File("src/main/assets/paletteButton.fxml");
    private EnumsForSprites element;

    /**
     * Creates a new button from an FXML template, given an Element enum and its corresponding sprite file.
     * @param img The specified image.
     * @throws IOException Thrown if there is an error in loading the FXML file.
     */
    public PaletteButton(EnumsForSprites element, Image img) throws IOException {
        URL url = TEMPLATE.toURI().toURL();
        Scene sc = new Scene(FXMLLoader.load(url));
        button = (Button) sc.lookup("#button");
        button.setGraphic(new ImageView(img));
        this.element = element;
    }

    /**
     * Attach an event handler that is fired when the button is clicked.
     * @param handler The event handler.
     */
    public void setOnClicked(EventHandler<MouseEvent> handler) {
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    public Button getButton() {
        return button;
    }

    public EnumsForSprites getElement() {
        return element;
    }
}
