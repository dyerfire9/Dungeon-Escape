package graphics;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
        clearErrorMsg();
        textField = (TextField) sc.lookup("#textField");
        okButton = (Button) sc.lookup("#button");
    }

    public void setErrorMsg(String msg) {
        errorMsg.setText("Error: " + msg);
    }

    public void clearErrorMsg() { errorMsg.setText(""); }

    public String getText() {
        return textField.getText();
    }

    public void addOnClickedButton(EventHandler<MouseEvent> handler) {
        okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    public void addOnKeyPressed(EventHandler<KeyEvent> handler) {
        textField.addEventHandler(KeyEvent.KEY_PRESSED, handler);
    }
}
