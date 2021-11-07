package graphics;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;




public class GraphicsLoader {

    public GraphicsLoader () {}

    public void drawBoard(GraphicsContext gc) {
        Image test = new Image("file:src/main/assets/tiles/cobble_blood1.png");

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j ++) {
                gc.drawImage(test, 32*i , 32*j);
            }
        }
    }
    public void drawPlayer(GraphicsContext gc) {
        Image playerSprite = new Image("file:src/main/assets/player/deep_elf_blademaster.png");


        gc.drawImage(playerSprite, 0, 0);
    }

}

