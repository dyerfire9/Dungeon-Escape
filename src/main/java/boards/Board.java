package boards;

import elements.MovableElement;
import elements.Tile;
import utils.PlayerState;
import utils.Point2D;
import utils.PointImagePair;

import java.util.ArrayList;

public class Board {
    private final int size;
    private final Tile[][] board;
    private ObjectManager objectStateManager;

    public Board(int size) {
        this.size = size;
        this.board = new Tile[size][size];
        this.objectStateManager = new ObjectManager(size - 1);

        this.fillBoard();
        this.fillEdges();
    }

    public int getSize() {
        return this.size;
    }

    public ArrayList<PointImagePair> getBoardSprites() {
        ArrayList<PointImagePair> pointImagePairs = new ArrayList<>();

        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                pointImagePairs.add(new PointImagePair(new Point2D(i, j), this.board[i][j].getSprite()));
            }
        }

        return pointImagePairs;
    }

    public boolean isTraversable(Point2D point) {
        int x = point.getX();
        int y = point.getY();

        return this.board[x][y].isTraversable();
    }

    public void fillBoard() {
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                this.board[i][j] = new Tile(true);
            }
        }
    }

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


    public ArrayList<PointImagePair> getMovableObjectPointImgPairs() {
        return this.objectStateManager.getPointImagePairs();
    }

    public PlayerState updatePlayerState(Point2D position, PlayerState playerState) {
        return this.objectStateManager.modifyPlayerState(position, playerState);
    }

    public void addMovableObject(MovableElement object){
        this.objectStateManager.addObject(object);
    }

    public void updateBoard(){
        this.objectStateManager.updateObjects();
    }

    public ObjectManager getObjectStateManager() {
        return objectStateManager;
    }
}

