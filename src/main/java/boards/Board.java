package boards;

import elements.MovableElement;
import elements.Tile;
import game.PlayerState;
import utils.Point2D;
import utils.PointImagePair;

import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable {
    private final int size;
    private final Tile[][] board;
    private ObjectManager objectManager;

    /**
     * A constructor for class Board.
     * @param size an integer chosen by the User to set up the size of the board.
     */
    public Board(int size) {
        this.size = size;
        this.board = new Tile[size][size];
        this.objectManager = new ObjectManager(size - 1);

        this.fillBoard();
        this.fillEdges();
    }

    /**
     * @return the size of the board.
     */
    public int getSize() {
        return this.size;
    }


    /**
     * @return a mapping between each location on the board and its String representation.
     */
    public ArrayList<PointImagePair> getBoardSprites() {
        ArrayList<PointImagePair> pointImagePairs = new ArrayList<>();

        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                pointImagePairs.add(new PointImagePair(new Point2D(i, j), this.board[i][j].getSprite()));
            }
        }

        return pointImagePairs;
    }

    /**
     * @param point a location on the board
     * @return a boolean that indicates whether the Player can move onto that position. Currently, only edges of the board or "walls" are non-traversable.
     */
    public boolean isTraversable(Point2D point) {
        int x = point.getX();
        int y = point.getY();

        return this.board[x][y].isTraversable();
    }

    /**
     * Pave the entire board with basic tiles.
     */
    public void fillBoard() {
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                this.board[i][j] = new Tile(true);
            }
        }
    }

    /**
     * Add non-traversable walls to the four edges of the board.
     */
    public void fillEdges() {
        for (int i = 0; i < this.getSize(); i ++) {

            this.board[0][i] = new Tile(false);
            this.board[this.getSize() - 1][i] = new Tile(false);
        }
        for (int i = 1; i < this.getSize() - 1; i ++) {

            this.board[i][0] = new Tile(false);
            this.board[i][this.getSize() - 1] = new Tile( false);
        }
    }


    /**
     * @return  a mapping between each location contained in the board's objectManager and its String representation.
     */
    public ArrayList<PointImagePair> getMovableObjectPointImgPairs() {
        return this.objectManager.getPointImagePairs();
    }

    /**
     * @param position player's current position
     * @param playerState player's current playerState
     * @return the new playerState after an object in objectManager interacts with the player
     */
    public PlayerState updatePlayerState(Point2D position, PlayerState playerState) {
        return this.objectManager.modifyPlayerState(position, playerState);
    }

    public void addMovableObject(MovableElement object){
        this.objectManager.addObject(object);
    }

    /**
     * Call on the board's objectManager to update the status of every object it contains .
     */
    public void updateBoard(){
        this.objectManager.updateObjects();
    }


    /**
     * @return the objectManager of the board.
     */
    public ObjectManager getObjectManager() {
        return objectManager;
    }
}

