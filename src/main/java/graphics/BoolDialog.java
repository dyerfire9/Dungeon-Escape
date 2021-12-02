package graphics;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BoolDialog extends Dialog {
    private Button yesButton;
    private Button noButton;

    public BoolDialog(String prompt) throws IOException {
        super(prompt);
        URL url = new File("src/main/assets/boolDialog.fxml").toURI().toURL();
        Scene sc = new Scene(FXMLLoader.load(url));
        stage.setScene(sc);

        yesButton = (Button) sc.lookup("#yesButton");
        noButton = (Button) sc.lookup("#noButton");
        label = (Label) sc.lookup("#prompt");
        label.setText(prompt);
    }

    public void addOnClickedYes(EventHandler<MouseEvent> handler) {
        yesButton.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    public void addOnClickedNo(EventHandler<MouseEvent> handler) {
        noButton.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }
}
