package game;

import elements.types.*;
import org.junit.*;
import utils.EnumsForSprites;
import utils.Point2D;

import java.util.ArrayList;

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
        Game game = new Game(8);
        game.setRunning(false);
        assert !game.isRunning();
        game.setRunning(true);
        assert game.isRunning();
    }

    @Test(timeout = 500)
    public void TestRemoveObject() {
        int totalObjects;
        Game game = new Game(15);
        ObjectManager objman = game.getObjectManager();
        objman.addPortal((new Point2D(5,12)));
        objman.addPortal((new Point2D(7,6)));
        objman.addGoal((new Point2D(14,13)));
        game.deleteObject(new Point2D(7,6));
        game.deleteObject(new Point2D(5,12));
        totalObjects = objman.getBoardObjects().size();

        assert(totalObjects == 1);
    }
}
