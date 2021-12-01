package graphics;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.EventEmitter;

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

        yesButton.setOnMouseClicked(this::onClickedYes);
        noButton.setOnMouseClicked(this::onClickedNo);
    }

    //------------ EVENT METHODS ------------//

    private void onClickedYes(MouseEvent event) {
        emit("userClickedYes");
        yesButton.setOnMouseClicked(null);
    }

    private void onClickedNo(MouseEvent event) {
        emit("userClickedNo");
        noButton.setOnMouseClicked(null);
    }
}
