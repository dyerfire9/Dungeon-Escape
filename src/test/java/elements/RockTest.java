package elements;

import game.Board;
import game.ObjectManager;
import org.junit.Test;
import utils.EnumsForSprites;
import utils.Point2D;

public class RockTest {

    @Test(timeout = 500)
    public void TestRock() {

        Board board = new Board(20);
        ObjectManager obm = new ObjectManager(board.getSize() - 1);

        Rock rock = new Rock(EnumsForSprites.ROCK, new Point2D(13, 14), true);
        board.fillBoard();
        board.fillEdges();

        obm.addObject(rock);

        for(Element boardObject : obm.getBoardObjects()) {
            if (boardObject instanceof Rock) {
                assert (boardObject.getPos() == rock.getPos());
            } else {
                assert (boardObject.getPos() != rock.getPos());
            }
        }
    }
}
