package graphics;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class PlayButtonController {

    private Button button;
    private boolean playMode;

    public PlayButtonController(Button button) {
        this.button = button;
        playMode = true;
        button.setOnMouseClicked(this::onMouseClicked);
    }

    private void onMouseClicked(MouseEvent event) {
        if (playMode) {
            button.setText("Play");
            playMode = false;
        } else {
            button.setText("Edit");
            playMode = true;
        }
    }

    public Button getButton() {
        return button;
    }

    public boolean isPlayMode() {
        return playMode;
    }

}
