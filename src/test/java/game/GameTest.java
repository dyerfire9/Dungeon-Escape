package game;

import elements.types.Element;
import org.junit.*;
import utils.EnumsForSprites;
import utils.Point2D;

// TODO add tests for all applicable game methods
public class GameTest {
    @Test(timeout = 500)
    public void TestGameBasics() {
        Game game = new Game(8);
        assert game.getBoard().getSize() == 8;
        Point2D p = new Point2D(5,5);
        assert Point2D.equals(game.getPlayerPosition(), p);
        assert game.getPlayerState().getPoints() == 100;
        assert game.getPlayerSprite() == EnumsForSprites.PLAYER;
    }

    @Test(timeout = 500)
    public void TestMovePlayer() {
        Game game = new Game(8);
        Point2D c = new Point2D(1,0);
        game.movePlayer(c);
        Point2D d = new Point2D(6,5);
        assert Point2D.equals(game.getPlayerPosition(), d);
    }

    @Test(timeout = 500)
    public void TestIsRunning() {
        Game game = new Game(8);
        assert game.isRunning();
    }

    @Test(timeout = 500)
    public void TestSetRunning() {
        Game game = new Game(10);
        game.setRunning(false);
        assert !game.isRunning();
        game.setRunning(true);
        assert game.isRunning();
    }

    @Test(timeout = 500)
    public void TestCheckOverLap() {
        Board board = new Board(15);

        board.fillBoard();
        board.fillEdges();

        Game game = new Game(board.getSize());

        assert(!game.checkOverlap(new Point2D(5,5)));

    }

    @Test(timeout = 500)
    public void TestGetSize() {
        Board board = new Board(15);

        board.fillBoard();
        board.fillEdges();

        Game game = new Game(board.getSize());

        assert(game.getSize() == 15);
    }
}
