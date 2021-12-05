package gui;
import graphics.GraphicsMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class GuiTest extends ApplicationTest{

    private Canvas canvas;
    private Parent mainNode;

    /**
     * Will be called with {@code @Before} semantics, i. e. before each test method.
     */
    @Override
    public void start(Stage stage) throws Exception {
        mainNode = FXMLLoader.load(GraphicsMain.class.getResource("/src/main/assets/testScene.fxml"));

        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    /* Just a shortcut to retrieve widgets in the GUI. */
    public <T extends Node> T find(final String query) {
        /* TestFX provides many operations to retrieve elements from the loaded GUI. */
        return lookup(query).query();
    }

    @Before
    public void setUp() {
        /* Just retrieving the tested widgets from the GUI. */
        canvas = find("#gameCanvas");
    }
    /* IMO, it is quite recommended to clear the ongoing events, in case of. */
    @After
    public void tearDown() throws TimeoutException {
        /* Close the window. It will be re-opened at the next test. */
        FxToolkit.hideStage();
        release(new KeyCode[] {});
        release(new MouseButton[] {});
    }

    @Test
    public void testWidgetsExist() {
        final String errMsg = "One of the widget cannot be retrieved anymore";
        assertNotNull(errMsg, canvas);
    }
}
