package graphics;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PaletteButton {

    private static final File TEMPLATE = new File("src/main/assets/paletteButton.fxml");
    private ImageView imageView;
    private Button button;

    /**
     * Creates a new button from an FXML template, with a specified button.
     * @param img The specified image.
     * @throws IOException Thrown if there is an error in loading the FXML file.
     */
    public PaletteButton(Image img) throws IOException {
        URL url = TEMPLATE.toURI().toURL();
        Scene sc = new Scene(FXMLLoader.load(url));
        button = (Button) sc.lookup("#button");
        imageView = (ImageView) sc.lookup("#img");
        imageView.setImage(img);
    }

    public void setOnClicked(EventHandler<MouseEvent> handler) {
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    public Button getButton() {
        return button;
    }
}
