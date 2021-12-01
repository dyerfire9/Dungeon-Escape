package graphics;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import utils.EventEmitter;

public abstract class Dialog extends EventEmitter {
    protected Stage stage;
    protected Label label;

    public Dialog(String prompt) {
        stage = new Stage();
        stage.setTitle("User Dialog");
        stage.setResizable(false);
    }

    public void show() {
        stage.show();
    }

    public void hide() {
        stage.hide();
    }
}
