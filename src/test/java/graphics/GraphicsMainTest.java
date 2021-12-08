package graphics;

import java.time.*;
import javafx.geometry.VerticalDirection;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)

public class GraphicsMainTest {
    private final GraphicsMain graphicsMain = new GraphicsMain();
    @Start
    public void start(Stage stage) throws Exception {
        graphicsMain.start(stage);

        stage.show();
    }

    @Test
    void try_opening_editor(FxRobot robot) {
        System.out.println("passed!");
        robot.clickOn(".button");



        robot.write("20");
        // robot.clickOn("#button");
    }
}
