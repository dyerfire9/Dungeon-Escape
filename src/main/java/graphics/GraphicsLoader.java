package graphics;

import game.Game;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import game.PlayerState;
import utils.Point2D;
import utils.PointImagePair;
import utils.EnumsForSprites;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Contains methods for drawing the game state on a Canvas.
 */
public class GraphicsLoader {

    public static final int DEFAULT_TILESIZE = 32;
    public static final int HIGHLIGHT_BORDER_WIDTH = 2;

    private static Font debugFont = new Font("Consolas", 16);

    // Represents the amount of space (in pixels) that a single tile takes up.
    // Added tileSize because we may not want to hardcode this value in the future.
    private int tileSize;

    private HashMap<EnumsForSprites, Image> strMapping = new HashMap<EnumsForSprites, Image>();

    /**
     * Constructs an instance with the default tile size.
     * Maps sprites representing elements on the game board to images.
     */
    public GraphicsLoader() {

        this.tileSize = DEFAULT_TILESIZE;
        this.strMapping.put(EnumsForSprites.IS_TRAVERSABLE,
                new Image("file:src/main/assets/tiles/cobble_blood1.png"));
        this.strMapping.put(EnumsForSprites.NOT_TRAVERSABLE,

                new Image("file:src/main/assets/tiles/torch1.png"));
        this.strMapping.put(EnumsForSprites.PLAYER,
                new Image("file:src/main/assets/player/deep_elf_blademaster.png"));
        this.strMapping.put(EnumsForSprites.ALLIGATOR,
                new Image("file:src/main/assets/player/animals/alligator.png"));
        this.strMapping.put(EnumsForSprites.ALLIGATOR_DEN_LEFT,
                new Image("file:src/main/assets/tiles/dngn_entrance_left.png"));
        this.strMapping.put(EnumsForSprites.ALLIGATOR_DEN_RIGHT,
                new Image("file:src/main/assets/tiles/dngn_entrance_right.png"));
        this.strMapping.put(EnumsForSprites.ALLIGATOR_DEN_UP,
                new Image("file:src/main/assets/tiles/dngn_entrance_up.png"));
        this.strMapping.put(EnumsForSprites.ALLIGATOR_DEN_DOWN,
                new Image("file:src/main/assets/tiles/dngn_entrance_down.png"));
        this.strMapping.put(EnumsForSprites.GOAL,
                new Image("file:src/main/assets/player/statues/guardian-eyeopen-flame3.png"));
        this.strMapping.put(EnumsForSprites.CHASER,
                new Image("file:src/main/assets/player/nonliving/molten_gargoyle.png"));
        this.strMapping.put(EnumsForSprites.PORTAL, new Image("file:src/main/assets/tiles/dngn_portal.png"));
        this.strMapping.put(EnumsForSprites.ROCK, new Image("file:src/main/assets/tiles/crystal_floor5.png"));
        this.strMapping.put(EnumsForSprites.PUSHABLE,
                new Image("file:src/main/assets/player/nonliving/ball_lightning.png"));

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
            gc.drawImage(strMapping.get(tile.getImg()), tileSize * point.getX(), tileSize * point.getY());
        }


       // Render elements
        for (PointImagePair obj: objects) {
            Point2D point = obj.getPoint();
            gc.drawImage(strMapping.get(obj.getImg()), tileSize * point.getX(), tileSize * point.getY());
        }

    }

    /**
     * Draws the player on a GraphicsContext instance.
     * @param gc The GraphicsContext to draw on.
     * @param game The specified Game instance to draw from.
     */
    public void drawPlayer(GraphicsContext gc, Game game) {
        Point2D point = game.getPlayerPosition();
        gc.drawImage(strMapping.get(game.getPlayerSprite()), tileSize * point.getX(), tileSize * point.getY());
    }

    /**
     * Draws debug info for the player's state.
     * @param gc The GraphicsContext to draw on.
     * @param point The position on the board to draw on.
     * @param game The specified Game instance to draw from.
     */
    public void drawPlayerState(GraphicsContext gc, Point2D point, Game game) {
        PlayerState currState = game.getPlayerState();

        gc.setFont(debugFont);
        gc.setFill(Color.MAGENTA);
        gc.fillText("Points: " + currState.getPoints(),
                point.getX(), point.getY());
        gc.fillText("Invincible: " + currState.checkInvincible(),
                point.getX(), point.getY() + debugFont.getSize());
        gc.fillText("Iframes: " + currState.getiFrames(),
                point.getX(), point.getY() + 2*debugFont.getSize());
        if (game.checkPlayerWon()) {
            gc.fillText("Won the game", point.getX(),
                    point.getY() + 3*debugFont.getSize());
        }
    }

    /**
     * Draws a border around a given tile's position.
     * @param gc The GraphicsContext to draw on.
     * @param point The position to draw on, in tile coordinates (i.e. array indices).
     */
    public void drawBorderAroundTile(GraphicsContext gc, Point2D point, Color color) {
        int w = HIGHLIGHT_BORDER_WIDTH;
        int px = point.getX() * tileSize;
        int py = point.getY() * tileSize;

        // Draw 4 very thin rectangles instead of 1 rectangle with a border, since the latter is not possible
        gc.setFill(color);
        gc.fillRect(px - w, py - w, tileSize + 2*w, w);
        gc.fillRect(px - w, py - w, w, tileSize + 2*w);
        gc.fillRect(px + tileSize, py, w, tileSize + w);
        gc.fillRect(px, py + tileSize, tileSize + w, w);
    }

    /**
     * Gets the instance's tile size.
     * @return The tile size.
     */
    public int getTileSize() {
        return tileSize;
    }
}

