package boards;

import elements.Element;
import elements.Movable;
import elements.Tile;
import javafx.scene.image.Image;
import utils.Point2D;
import utils.PointImagePair;

import java.util.ArrayList;

public class Board {
    private final int size;
    private final Tile[][] board;
    private ObjectStateManager objectStateManager;

    public Board(int size) {
        this.size = size;
        this.board = new Tile[size][size];
        this.objectStateManager = new ObjectStateManager();

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


    public void addMovableObject(Movable object){
        this.objectStateManager.addObject(object);
    }

    public void updateBoard(){
        this.objectStateManager.updateObjects();
    }

    public void updateObjects(){
        this.objectStateManager.updateObjects();
    }
}

