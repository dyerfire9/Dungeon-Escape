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

    /**
     * Constructs a KeyboardReader given a JavaFX scene graph.
     * @param mainScene The scene graph.
     */
    public KeyboardReader(Scene mainScene) {
        this.mainScene = mainScene;
        activeKeys = new HashSet<>();
    }

    /**
     * Attaches key listeners to the scene graph. Should only be called once.
     */
    public void addKeyListeners() {
        mainScene.setOnKeyPressed(event -> activeKeys.add(event.getCode().toString()));
        mainScene.setOnKeyReleased(event -> activeKeys.remove(event.getCode().toString()));
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

}
