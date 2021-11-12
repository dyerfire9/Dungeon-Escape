import boards.Board;
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

    //@Test(timeout = 50)
    //public void TestBoardToString_1() {
    //    Board board = new Board(10);
    //    assert(board.toString().equals("Board{size=10, board=[x, x, x, x, x, x, x, x, x, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, x, x, x, x, x, x, x, x, x, null]}"));
    //}

    //@Test(timeout =50)
    //public void TestBoardToString_2() {
    //    Board board = new Board(15);
    //    assert(board.toString().equals("Board{size=15, board=[x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
    //            "x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, null]}"));

    //}
}
