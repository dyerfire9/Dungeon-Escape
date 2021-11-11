package graphics;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.util.HashSet;

/**
 * Class responsible for detecting keyboard input.
 */
public class KeyboardReader {
    private Node node;
    private HashSet<String> activeKeys;
    private HashSet<String> pressedKeys;

    /**
     * Constructs a KeyboardReader given a JavaFX scene graph.
     * @param node The scene graph.
     */
    public KeyboardReader(Node node) {
        this.node = node;
        activeKeys = new HashSet<>();
        pressedKeys = new HashSet<>();
    }

    /**
     * Attaches key listeners to the specified node. Should only be called once.
     */
    public void addKeyListeners() {
        node.setOnKeyPressed(event -> {
            if (!pressedKeys.contains(event.getCode().toString())) {
                activeKeys.add(event.getCode().toString());
            }
            pressedKeys.add(event.getCode().toString());
        });
        node.setOnKeyReleased(event -> {
            pressedKeys.remove(event.getCode().toString());
        });
    }


    /* GETTERS/SETTERS */

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public HashSet<String> getActiveKeys() {
        return activeKeys;
    }

    public HashSet<String> getPressedKeys() {
        return pressedKeys;
    }

}
