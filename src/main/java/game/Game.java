package game;

import utils.EnumsForSprites;
import utils.Point2D;
import utils.PointImagePair;

import java.io.Serializable;
import java.util.ArrayList;


public class Game implements Serializable {

    private boolean isRunning;
    private Board board;
    private Player player;
    private int size;

    /**
     * A constructor for the Game class.
     * Currently, each new Game is hard-coded to have a new Player at starting position (5, 5).
     * @param size the size of the board, which is an arbitrary integer to be chosen by the human user
     */
    public Game (int size) {
        this.board = new Board(size);
        this.size = size;
        this.isRunning = true;
        Point2D pos = new Point2D(5, 5);
        this.player = new Player(pos);
    }


    /**
     * Moves the Player to a new position.
     * @param move the incremental movement the Player is to make from its current position.
     */
    public void movePlayer(Point2D move) {
        Point2D currentPos = player.getPos();
        Point2D newPos = Point2D.add(currentPos, move);
        boolean traversable = board.isTraversable(newPos);

        if (traversable)  {
            player.setPos(newPos);
        }
        else  {
            System.out.println("Met a wall!");
        }
    }


    /**
     * A wrapper method that calls on the underlying board to update itself.
     */
    public void updateBoard() {
        this.board.updateBoard();
    }

    /**
     * Updates the Player's PlayerState using the board's feedback based on the Player's current location. Also
     * decreases the Player's temporary invincibility-frame-count by 1.
     */
    public void updatePlayerState() {
        PlayerState currPlayerState = this.player.playerState;
        Point2D position = this.player.getPos();
        PlayerState modifiedPlayerState = this.board.updatePlayerState(position, currPlayerState);

        this.player.setPlayerState(modifiedPlayerState);
        this.player.decrementIframes();
    }

    public boolean checkOverlap(Point2D point) {
        if (Point2D.equals(this.player.getPos(), point)) {
            return false;
        }
        else return !board.checkOverlap(point);
    }

    /**
     * Getters and Setters for game status.
     */

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Board getBoard() {return board;}

    public ArrayList<PointImagePair> getBoardTiles() {
        return this.board.getBoardSprites();
    }

    public ArrayList<PointImagePair> getBoardMovableObjects() {
        return this.board.getMovableObjectPointImgPairs();
    }

    public EnumsForSprites getPlayerSprite() {
        return this.player.getSprite();
    }

    public Point2D getPlayerPosition() {
        return this.player.getPos();
    }

    public PlayerState getPlayerState() {return this.player.getPlayerState();}

    public boolean checkPlayerWon() {
        return this.player.getPlayerState().getWinningState();
    }

    public int getSize(){return this.size;}

    //-----Adding Elements to the board----//
    public void addGoal(Point2D pos) {
        this.board.addGoal(pos);
    }
    public void addRightAlligatorDen(Point2D pos) {
        this.board.addRightAlligatorDen(pos);
    }
    public void addLeftAlligatorDen(Point2D pos) {
        this.board.addLeftAlligatorDen(pos);
    }
    public void addUpAlligatorDen(Point2D pos) {
        this.board.addUpAlligatorDen(pos);
    }
    public void addDownAlligatorDen(Point2D pos) {
        this.board.addDownAlligatorDen(pos);
    }
}
