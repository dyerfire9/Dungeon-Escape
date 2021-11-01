// TODO add tests for all applicable game methods
import Boards.Board;
import Boards.MovableCoverBoard;
import Boards.StationaryCoverBoard;
import InteractiveElements.MovableChangePoints;
import InteractiveElements.StationaryChangePoints;

import java.util.ArrayList;
import org.junit.*;

public class GameTest {
    @Test(timeout = 50)
    public void TestGetRunning(){
        Game game = new Game();
        assert game.getRunning();
    }

    @Test(timeout = 100)
    public void TestSetRunning(){
        Game game = new Game();
        game.setRunning(false);
        assert !game.getRunning();
        game.setRunning(true);
        assert game.getRunning();
    }

    @Test(timeout = 50)
    public void TestMakeMove(){
        Game game = new Game();
        int[] move = new int[2];
        move[0] = 4;
        move[1] = 3;
        game.makeMove(move);
        assert game.getPlayer().getPos() == 175;
        //int[] again = new int[2];
        //move[0] = 3;
        //move[1] = 6;
        //game.makeMove(again);
        //assert game.getPlayer().getPos() == 244;
    }
}
