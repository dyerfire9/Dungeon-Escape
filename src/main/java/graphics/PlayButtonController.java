package graphics;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Controller class for the Play/Edit button in the UI.
 */
public class PlayButtonController {

    private Button button;
    private boolean playMode;

    /**
     * Instantiates the controller by linking it to a specified button.
     * @param button The button to link to the controller.
     */
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

    /**
     * Returns the button the controller is linked to.
     * @return The Button instance.
     */
    public Button getButton() {
        return button;
    }

    /**
     * Returns true if the button thinks the game is in Play mode, false otherwise.
     * @return The boolean value.
     */
    public boolean isPlayMode() {
        return playMode;
    }

}
