package game;

import boards.Board;
import elements.ChangePoints;
import javafx.scene.image.Image;
import utils.Point2D;
import utils.PointImagePair;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Game {

    private boolean isRunning;
    private Board board;
    private Player player;

    public Game (int size) {
        this.board = new Board(size);

        this.isRunning = true;
        Point2D pos = new Point2D(5, 5);
        this.player = new Player(pos);
    }


    public void movePlayer(Point2D move) {
        Point2D currentPos = player.getPos();
        Point2D newPos = Point2D.add(currentPos, move);
        boolean element = board.isTraversable(newPos);
        // TODO: need to refine this logic...if newPos has a points-changer, can game.Player still move onto that position? In pacman, you "eat" a points-changer, and move onto its position.

        if (element)  {
            player.setPos(newPos);
        }
        else  {
            System.out.println("Met an element!");
        }
    }


//    public void changePlayer(Object e) {
//        if (e instanceof ChangePoints){
//           player.changePoints(((ChangePoints) e).getChange());
//        }
//        System.out.println("Your now have " + player.getPoints() + " points.");
//    }




    // Getter & Setter for game status.
    public boolean isRunning() {
        return this.isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public ArrayList<PointImagePair> getBoardTiles() {
        return this.board.getBoardSprites();
    }

    public ArrayList<PointImagePair> getBoardMovableObjects() {
        return this.board.getMovableObjectPointImgPairs();
    }

    public Image getPlayerSprite() {
        return this.player.getSprite();
    }

    public Point2D getPlayerPosition() {
        return this.player.getPos();
    }

}
