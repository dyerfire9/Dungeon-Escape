package graphics;

import game.Game;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import utils.Point2D;
import utils.PointImagePair;

import java.util.ArrayList;


public class GraphicsLoader {

    public GraphicsLoader () {}

    public void drawBoard(GraphicsContext gc, Game game) {

        ArrayList<PointImagePair> tiles = game.getBoardTiles();
        ArrayList<PointImagePair> objects = game.getBoardMovableObjects();

        // Render tiles
        for (PointImagePair tile: tiles) {
            Point2D point = tile.getPoint();
            gc.drawImage(tile.getImg(), 32*point.getX(), 32*point.getY());
        }

        for (PointImagePair obj: objects) {
            Point2D point = obj.getPoint();
            gc.drawImage(obj.getImg(), 32* point.getX(), 32* point.getY());
        }

    }
    public void drawPlayer(GraphicsContext gc, Game game) {
        Point2D point = game.getPlayerPosition();
        gc.drawImage(game.getPlayerSprite(), 32*point.getX(), 32*point.getY());
    }

}

