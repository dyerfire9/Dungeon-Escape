import org.junit.*;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class BoardTest {
    @Test(timeout = 50)
    public void TestBoardToString_1() {
        Board board = new Board(10);
        assert(board.toString().equals("xoooooooox"));
    }

    @Test(timeout =50)
    public void TestBoardToString_2() {
        Board board = new Board(15);
        assert(board.toString().equals("xooooooooooooox"));
    }
}
