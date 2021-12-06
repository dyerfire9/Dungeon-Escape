package graphics.controller;

import game.Game;
import graphics.GraphicsLoader;
import graphics.enums.ToolMode;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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

    private final Font DEBUG_FONT = new Font("Consolas", 12);

    private ToolMode toolMode = ToolMode.PLACE;
    private EnumsForSprites element;

    private Game game;
    private GraphicsLoader gl;

    @FXML
    private Canvas canvas;
    private AnimationTimer timer;
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
        // Build node structure
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

    @Override
    public void initialize() {
        System.out.println("RenderPane initialized");

        // Attach event listeners
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onMouseClicked);
        canvas.addEventHandler(KeyEvent.KEY_PRESSED, this::onKeyPressed);
        canvas.addEventHandler(KeyEvent.KEY_RELEASED, this::onKeyReleased);
        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, this::onMouseMoved);

        // Default map
        this.addGoal(new Point2D(game.getSize() - 2, game.getSize() - 2));
        this.game.addDownAlligatorDen(new Point2D(game.getSize() / 2, 1));
        this.game.addRightAlligatorDen(new Point2D(1, game.getSize() / 2));

        // Init and start timer
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                tickAndRender(now - currentNanoTime);
                currentNanoTime = now;
            }
        };
        timer.start();
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

        // Clears the canvas
        clearCanvas();

        if (!this.makeMode) {
            // Updates game state
            game.updateBoard();
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
        gl.drawPlayerState(gc, new Point2D(32 * 16, 32), game);
        drawDebugInfo(1000000000.0 / deltaTime, new Point2D(50, 50));
    }

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

    public void clearCanvas() {
        GraphicsContext gc = getContext();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private boolean checkClickedPoint(Point2D point) {
        boolean boundCondition = (( 1 <= point.getX()  && point.getX() < this.game.getSize())
                && ( 1 <= point.getY()  && point.getY() < this.game.getSize()));

        boolean noOverlapCondition = game.checkOverlap(point);

        return boundCondition && noOverlapCondition;
    }

    //------------ EVENT METHODS ------------//

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

            pressedKeys.add(event.getCode().toString());
        }
    }

    private void onKeyReleased(KeyEvent event) {
        pressedKeys.remove(event.getCode().toString());
    }

    private void onMouseClicked(MouseEvent event) {
        canvas.requestFocus();

        if (this.makeMode){
            onMouseClickedMakeMode(event);
        }
    }

    private void onMouseClickedMakeMode(MouseEvent event) {
        Point2D mousePoint = new Point2D(
                (int) Math.floor(event.getX() / gl.getTileSize()),
                (int) Math.floor(event.getY() / gl.getTileSize()));
        if (this.checkClickedPoint(mousePoint)) {
            if (element == EnumsForSprites.GOAL) {
                game.addGoal(mousePos);
            } else if (element == EnumsForSprites.ALLIGATOR_DEN_UP) {
                game.addUpAlligatorDen(mousePos);
            } else if (element == EnumsForSprites.ALLIGATOR_DEN_DOWN) {
                game.addDownAlligatorDen(mousePos);
            } else if (element == EnumsForSprites.ALLIGATOR_DEN_LEFT) {
                game.addLeftAlligatorDen(mousePos);
            } else if (element == EnumsForSprites.ALLIGATOR_DEN_RIGHT) {
                game.addRightAlligatorDen(mousePos);
            } else {
                System.out.printf("No implementation for placing element '%s'.", element);
            }
            GraphicsContext gc = canvas.getGraphicsContext2D();

            // Clears the canvas
            clearCanvas();
            // Draws new game state
            gl.drawBoard(gc, game);
            gl.drawPlayer(gc, game);
        }
    }

    private void onMouseMoved(MouseEvent event) {
        int tileSize = gl.getTileSize();
        mousePos = new Point2D((int) event.getX() / tileSize,
                (int) event.getY() / tileSize);
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

    public void setToolMode(ToolMode toolMode) {
        this.toolMode = toolMode;
    }

    public void setElement(EnumsForSprites element) {
        this.element = element;
    }

    //TODO: Add docs here
    public void changeGameState() {
        if (!this.makeMode) {
            this.resetObjectsToBaseState();
            GraphicsContext gc = canvas.getGraphicsContext2D();

            // Clears the canvas
            clearCanvas();
            // Draws new game state
            gl.drawBoard(gc, game);
            gl.drawPlayer(gc, game);
        }
        this.makeMode = !this.makeMode;
    }

    //TODO: Add docs here
    public void resetObjectsToBaseState() {
        this.game.resetObjectsToBaseState();
    }

    //-----------------Board Element Adders--------------//
    // Object-specific add methods to be called by gameMaker

    //TODO: Add docs here
    public void addGoal(Point2D pos) {
        this.game.addGoal(pos);
    }
}
