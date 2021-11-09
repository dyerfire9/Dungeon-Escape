import boards.Board;
import org.junit.*;

// TODO add tests for all applicable game methods
public class GameTest {
    //@Test(timeout = 50)
    //public void TestMovePlayer() {
    //    Board board = new Board(8);
    //    Game game = new Game(board);
    //}

    @Test(timeout = 50)
    public void TestChangePlayer() {
        Board board = new Board(8);
        Game game = new Game(board);
    }

    @Test(timeout = 50)
    public void TestIsRunning() {
        Board board = new Board(8);
        Game game = new Game(board);
        assert game.isRunning();
    }

    @Test(timeout = 50)
    public void TestSetRunning() {
        Board board = new Board(8);
        Game game = new Game(board);
        game.setRunning(false);
        assert !game.isRunning();
        game.setRunning(true);
        assert game.isRunning();
    }
}
