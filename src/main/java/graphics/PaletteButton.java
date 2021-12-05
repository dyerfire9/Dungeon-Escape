package graphics;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PaletteButton {

    private static final File TEMPLATE = new File("src/main/assets/paletteButton.fxml");
    private ImageView imageView;
    private Button button;

    public PaletteButton(Image img) throws IOException {
        URL url = TEMPLATE.toURI().toURL();
        Scene sc = new Scene(FXMLLoader.load(url));
        button = (Button) sc.lookup("#button");

    }

}
