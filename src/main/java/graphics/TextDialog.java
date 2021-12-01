package graphics;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TextDialog extends Dialog {
    private TextField textField;
    private Label errorMsg;
    private Button okButton;

    public TextDialog(String prompt) throws IOException {
        super(prompt);

        URL url = new File("src/main/assets/textDialog.fxml").toURI().toURL();
        Scene sc = new Scene(FXMLLoader.load(url));
        stage.setScene(sc);

        label = (Label) sc.lookup("#prompt");
        label.setText(prompt);
        errorMsg = (Label) sc.lookup("#errorMsg");
        errorMsg.setText("");
        textField = (TextField) sc.lookup("#textField");
        okButton = (Button) sc.lookup("#button");

        textField.setOnKeyPressed(this::onKeyTyped);
        okButton.setOnMouseClicked(this::onClickedButton);
    }

    public void setErrorMsg(String msg) {
        errorMsg.setText("Error: " + msg);
    }

    private String getUserText() {
        return textField.getText();
    }

    //------------ EVENT METHODS ------------//

    private void onClickedButton(MouseEvent event) {
        emit("userSubmit", getUserText());
    }

    private void onKeyTyped(KeyEvent event) {
        String keyCode = event.getCode().toString();

        emit("userKeyPressed", keyCode);
        if (keyCode.equals("ENTER")) {
            emit("userSubmit", getUserText());
        }
    }
}
