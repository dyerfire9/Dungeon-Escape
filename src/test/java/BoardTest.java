import Boards.Board;
import org.junit.*;

public class BoardTest {
    @Test(timeout = 50)
    public void TestBoardToString_1() {
        Board board = new Board(10);
        assert(board.toString().equals("Board{size=10, board=[x, x, x, x, x, x, x, x, x, x, null, " +
                "x, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, x, null, " +
                "x, x, x, x, x, x, x, x, x, x, null]}"));
    }

    @Test(timeout =50)
    public void TestBoardToString_2() {
        Board board = new Board(15);
        assert(board.toString().equals("Board{size=15, board=[x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, null, null, null, null, null, null, null, null, null, null, null, null, null, x, null, " +
                "x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, null]}"));

    }
}
