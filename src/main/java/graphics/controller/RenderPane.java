package graphics.controller;

import game.Game;
import graphics.GraphicsLoader;
import graphics.enums.ToolMode;
import game.GameSeeder;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import utils.EnumsForSprites;
import utils.Point2D;

import java.util.HashSet;

/**
 * This class encapsulates a Canvas instance that renders the game. This class in theory makes the Canvas
 * easier to manipulate within a larger scene graph.
 */
public class RenderPane implements FXMLController {

    private final Font DEBUG_FONT = new Font("Consolas", 14);

    private ToolMode toolMode = ToolMode.PLACE;
    private EnumsForSprites element;

    private Game game;
    private GameSeeder gameSeeder;
    private GraphicsLoader gl;

    @FXML
    private AnchorPane root;
    @FXML
    private ScrollPane canvasParent;

    private Canvas canvas;
    private AnimationTimer timer;
    private boolean showDebug = true;
    private long tick = 0;
    private long currentNanoTime;
    private boolean makeMode = false;
    private Point2D mousePos = new Point2D(0, 0);
    private HashSet<String> pressedKeys = new HashSet<>();

    /**
     * Constructs a pane with a desired screen size.
     * @param size The desired screen size.
     */
    public RenderPane(Game game, Point2D size) {

        canvas = new Canvas(size.getX(), size.getY());
        canvas.setFocusTraversable(true);
        canvas.requestFocus();

        // Init some other fields
        gl = new GraphicsLoader();
        this.game = game;
        currentNanoTime = System.nanoTime();
    }

    /**
     * Makes a new instance given only a Game instance, with the screen size automatically calculated.
     * @param game The Game instance.
     */
    public RenderPane(Game game) {
        this(game,
                new Point2D(GraphicsLoader.DEFAULT_TILESIZE * game.getSize(),
                        GraphicsLoader.DEFAULT_TILESIZE * game.getSize()));
    }

    /**
     * Implements the initialize() method inherited from the FXMLController interface.
     * This method will be called once on an implementing controller when the contents of
     * its associated document have been completely loaded.
     * This implementation is tailored because more control over the behavior
     * of the controller and the elements it manages is required.
     */
    @Override
    public void initialize() {

        System.out.println("RenderPane initialized");

        // Attach event listeners
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onMouseClicked);
        canvas.addEventHandler(KeyEvent.KEY_PRESSED, this::onKeyPressed);
        canvas.addEventHandler(KeyEvent.KEY_RELEASED, this::onKeyReleased);
        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, this::onMouseMoved);

        canvasParent.setContent(canvas);

        // Init and start timer
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                tickAndRender(now - currentNanoTime);
                currentNanoTime = now;
            }
        };
        timer.start();
        this.gameSeeder = new GameSeeder(this.game);
    }

    //------------ PUBLIC METHODS ------------//

    /**
     * Starts/restarts the game's tick cycle.
     */
    public void start() {
        System.out.printf("Game timer started at tick=%d.%n", tick);
        makeMode = false;
    }

    /**
     * Pauses the game's tick cycle.
     */
    public void stop() {
        System.out.printf("Game timer stopped at tick=%d.%n", tick);
        makeMode = true;
    }

    //------------ RENDERING METHODS ------------//

    /**
     * Processes one tick cycle of the game, which consists of the following steps (in order):
     * 1) Clear the canvas
     * 2) Update game state
     * 3) Draw new game state
     * @param deltaTime Time elapsed (in nanoseconds) since the last call of the function.
     */
    private void tickAndRender(long deltaTime) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.setWidth(root.getWidth());
        canvas.setHeight(root.getHeight());
        // Clears the canvas
        clearCanvas();

        if (!this.makeMode) {
            if (this.game.checkPlayerLose() | this.game.checkPlayerWon()) {
                this.game.resetGameToBaseState();
            }

            // Clears the canvas
            clearCanvas();

            // Updates game state
            game.updateObjects();
            game.updatePlayerState();

            // Increments tick number
            tick += 1;
        }

        // Draws new game state
        gl.drawBoard(gc, game);
        gl.drawPlayer(gc, game);

        if (this.makeMode) {
            gl.drawBorderAroundTile(gc, mousePos, Color.LIME);
        }

        // Draws debug info for new game state
        if (showDebug) {
            gl.drawPlayerState(gc, new Point2D(50, 100), game);
            drawDebugInfo(1000000000.0 / deltaTime, new Point2D(50, 50));
        }
        gc.setFont(DEBUG_FONT);
        gc.setFill(Color.MAGENTA);
        gc.fillText("Press [`] to toggle debug info", 50, 30);
    }

    /**
     * This method draws the frame-per-second, user-pressed-key, and invincibility-frame information of the Player on the canvas.
     * @param fps frame-per-second of rendering
     * @param pos the position on the canvas to draw this text information
     */
    private void drawDebugInfo(double fps, Point2D pos) {
        GraphicsContext gc = getContext();
        gc.setFill(Color.MAGENTA);
        gc.setFont(DEBUG_FONT);

        gc.fillText(String.format("FPS: %.1f", fps),
                pos.getX(), pos.getY() + DEBUG_FONT.getSize());
        gc.fillText(String.format("PressedKeys: %s", pressedKeys.toString()),
                pos.getX(), pos.getY() + 2*DEBUG_FONT.getSize());
        gc.fillText(String.format("Frame: %d", tick),
                pos.getX(), pos.getY() + 3*DEBUG_FONT.getSize());
    }

    /**
     * A method to clear the canvas.
     */
    public void clearCanvas() {
        GraphicsContext gc = getContext();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    /**
     * Checks to see whether a position (represented by a Point2D object) is within the boundaries of the game board.
     * @param point a position
     * @return whether it is located within the boundaries of the game board
     */
    private boolean checkWithinBounds(Point2D point) {
        boolean boundCondition = (( 1 <= point.getX()  && point.getX() < this.game.getSize() - 1)
                && ( 1 <= point.getY()  && point.getY() < this.game.getSize() - 1));
        return boundCondition;
    }

    /**
     * A wrapper method that calls on the game's checkOverlap() to see if a position is occupied by Player or an Element.
     * @param point a position
     * @return true if a position is NOT occupied by Player or an Element.
     */
    private boolean checkOverlap(Point2D point) {
        return game.checkOverlap(point);
    }

    //------------ EVENT METHODS ------------//

    /**
     * A method to read user's keypress, translate it into a 2D movement, and send to the game to move the Player.
     * @param event a keypress event
     */
    private void onKeyPressed(KeyEvent event) {
        String keyCode = event.getCode().toString();

        // Disables all other keybinds when game is paused.
        if (!makeMode) {
            // Movement-related keybinds
            if (keyCode.equals("W") && !pressedKeys.contains(keyCode)) {
                game.movePlayer(new Point2D(0, -1));
            }
            if (keyCode.equals("S") && !pressedKeys.contains(keyCode)) {
                game.movePlayer(new Point2D(0, 1));
            }
            if (keyCode.equals("A") && !pressedKeys.contains(keyCode)) {
                game.movePlayer(new Point2D(-1, 0));
            }
            if (keyCode.equals("D") && !pressedKeys.contains(keyCode)) {
                game.movePlayer(new Point2D(1, 0));
            }
        }
        if (keyCode.equals("BACK_QUOTE") && !pressedKeys.contains(keyCode)) {
            if (showDebug) {
                showDebug = false;
            } else {
                showDebug = true;
            }
        }
        pressedKeys.add(event.getCode().toString());
    }

    /**
     * A method to remove an expiring keypress event from the HashSet "pressedKeys" upon key release.
     * @param event the expiring keypress event
     */
    private void onKeyReleased(KeyEvent event) {
        pressedKeys.remove(event.getCode().toString());
    }

    /**
     * A method to read mouse-clicks the  on the canvas.
     * @param event a mouse event
     */
    private void onMouseClicked(MouseEvent event) {
        canvas.requestFocus();

        if (this.makeMode){
            onMouseClickedMakeMode(event);
        }
    }

    /**
     * A method to read if mouse clicked on an Element on the canvas in the Make Mode. If so, re-draw the canvas with the new Element planted.
     * @param event a mouse event
     */
    private void onMouseClickedMakeMode(MouseEvent event) {
        if (this.checkWithinBounds(mousePos)) {
            if (this.toolMode == ToolMode.PLACE && this.checkOverlap(mousePos)) {
                gameSeeder.add(element, mousePos);

            } else if (this.toolMode == ToolMode.DELETE) {
                this.game.deleteObject(mousePos);
            }

            GraphicsContext gc = canvas.getGraphicsContext2D();

            // Clears the canvas
            clearCanvas();
            // Draws new game state
            gl.drawBoard(gc, game);
            gl.drawPlayer(gc, game);
        }

    }

    /**
     * A method to map the position of a mouse-clicks on the canvas to a square-tile on the game board that encompasses that location.
     * @param event a mouse event
     */
    private void onMouseMoved(MouseEvent event) {
        int tileSize = gl.getTileSize();
        mousePos = new Point2D(
                (int) Math.floor(event.getX() / gl.getTileSize()),
                (int) Math.floor(event.getY() / gl.getTileSize()));
    }

    //------------ GETTERS AND SETTERS ------------//

    /**
     * A shortcut for getCanvas().getGraphicsContext2D().
     * @return The Canvas' GraphicsContext.
     */
    public GraphicsContext getContext() {
        return canvas.getGraphicsContext2D();
    }

    /**
     * Gets the Canvas associated with this instance.
     * @return The Canvas instance.
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Gets the Game associated with this instance.
     * @return The Game instance.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set the toolMode attribute of this instance.
     * @param toolMode the new toolMode to be used
     */
    public void setToolMode(ToolMode toolMode) {
        this.toolMode = toolMode;
    }

    /**
     * Set the Element attribute of this instance.
     * @param element the new element to be used
     */
    public void setElement(EnumsForSprites element) {
        this.element = element;
    }


    /**
     * A method to switch the Game between made-mode and play-mode. Upon a switch, clears the canvas and re-draws the board and Player.
     */
    public void changeGameState() {
        if (!this.makeMode) {
            this.resetGameToBaseState();
            GraphicsContext gc = canvas.getGraphicsContext2D();

            // Clears the canvas
            clearCanvas();
            // Draws new game state
            gl.drawBoard(gc, game);
            gl.drawPlayer(gc, game);
        }
        this.makeMode = !this.makeMode;
    }

    /**
     * A method to reset the Game to its base state.
     */
    public void resetGameToBaseState() {
        this.game.resetGameToBaseState();
    }
}
