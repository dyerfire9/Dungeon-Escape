package game;

import game.Board;
import org.junit.*;
import utils.Point2D;

public class BoardTest {
    @Test(timeout = 50)
    public void TestBoard(){
        Board board = new Board(8);
        Point2D a = new Point2D(5,5);
        Point2D b = new Point2D(0,3);
        assert board.isTraversable(a);
        assert !board.isTraversable(b);
    }

}
