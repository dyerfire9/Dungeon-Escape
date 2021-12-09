package graphics.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class PlaySave implements FXMLController {

    @FXML
    private AnchorPane root;
    @FXML
    private Button playButton;
    @FXML
    private Button saveButton;

    private boolean inPlayMode;

    public PlaySave() {
        inPlayMode = true;
    }

    public boolean isInPlayMode() {
        return inPlayMode;
    }

    @Override
    public void initialize() {
        System.out.println("PlaySave initialized");
        saveButton.setVisible(false);
        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (inPlayMode) {
                playButton.setText("Play");
                inPlayMode = false;
                saveButton.setVisible(true);
            } else {
                playButton.setText("Pause");
                inPlayMode = true;
                saveButton.setVisible(false);
            }
        });
    }

    public void addOnClickedPlay(EventHandler<MouseEvent> handler) {
        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    public void addOnClickedSave(EventHandler<MouseEvent> handler) {
        saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }
}
