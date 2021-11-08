package graphics;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.util.HashSet;

/**
 * Class responsible for detecting keyboard input.
 */
public class KeyboardReader {
    private Scene mainScene;
    private HashSet<String> activeKeys;
    private HashSet<String> pressedKeys;

    /**
     * Constructs a KeyboardReader given a JavaFX scene graph.
     * @param mainScene The scene graph.
     */
    public KeyboardReader(Scene mainScene) {
        this.mainScene = mainScene;
        activeKeys = new HashSet<>();
        pressedKeys = new HashSet<>();
    }

    /**
     * Attaches key listeners to the scene graph. Should only be called once.
     */
    public void addKeyListeners() {
        mainScene.setOnKeyPressed(event -> pressedKeys.add(event.getCode().toString()));
        mainScene.setOnKeyReleased(event -> {
            if (pressedKeys.contains(event.getCode().toString())) {
                activeKeys.add(event.getCode().toString());
            }
            pressedKeys.remove(event.getCode().toString());
        });
    }


    /* GETTERS/SETTERS */

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public HashSet<String> getActiveKeys() {
        return activeKeys;
    }

    public HashSet<String> getPressedKeys() {
        return pressedKeys;
    }

}
