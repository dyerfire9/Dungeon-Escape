package graphics;

import game.Game;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import utils.PlayerState;
import utils.Point2D;
import utils.PointImagePair;

import java.util.ArrayList;


/**
 * Contains method to draw the board on a canvas element.
 */
public class GraphicsLoader {

    // Represents the amount of space (in pixels) that a single tile takes up.
    // Added tileSize because we may not want to hardcode this value in the future.
    private int tileSize;

    /**
     * Constructs an instance with the default tile size.
     */
    public GraphicsLoader() {
        this.tileSize = 32;
    }

    /**
     * Constructs an instance with a specified tile size.
     * @param tileSize The tile size.
     */
    public GraphicsLoader(int tileSize) {
        this.tileSize = tileSize;
    }

    /**
     * Draws the current state of the board on a GraphicsContext instance.
     * @param gc The GraphicsContext to draw on.
     * @param game The specified Game instance to draw from.
     */
    public void drawBoard(GraphicsContext gc, Game game) {

        ArrayList<PointImagePair> tiles = game.getBoardTiles();
        ArrayList<PointImagePair> objects = game.getBoardMovableObjects();

        // Render tiles
        for (PointImagePair tile: tiles) {
            Point2D point = tile.getPoint();
            gc.drawImage(tile.getImg(), tileSize * point.getX(), tileSize * point.getY());
        }

        for (PointImagePair obj: objects) {
            Point2D point = obj.getPoint();
            gc.drawImage(obj.getImg(), tileSize * point.getX(), tileSize * point.getY());
        }

    }

    /**
     * Draws the player on a GraphicsContext instance.
     * @param gc The GraphicsContext to draw on.
     * @param game The specified Game instance to draw from.
     */
    public void drawPlayer(GraphicsContext gc, Game game) {
        Point2D point = game.getPlayerPosition();
        gc.drawImage(game.getPlayerSprite(), tileSize * point.getX(), tileSize * point.getY());
    }

    public void drawPlayerState(GraphicsContext gc, Point2D point, Game game) {
        PlayerState currState = game.getPlayerState();

        Font debugFont = new Font("Consolas", 12);
        gc.setFont(debugFont);
        gc.setFill(Color.MAGENTA);
        gc.fillText("Points: " + currState.getPoints(), point.getX(), point.getY() + 12);
        gc.fillText("Invincible: " + currState.checkInvincible(), point.getX(), point.getY() + 24);
        gc.fillText("Iframes: " + currState.getiFrames(), point.getX(), point.getY() + 36);

    }
}

