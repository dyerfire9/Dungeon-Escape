package elements.types;

import game.Board;
import game.ObjectManager;
import org.junit.Test;
import game.PlayerState;
import utils.Point2D;
import utils.EnumsForSprites;

public class GoalTest {
    @Test(timeout = 500)
    public void TestGoal() {

        Board board = new Board(20);
        ObjectManager obm = new ObjectManager(board.getSize() - 1);

        Goal goal = new Goal(EnumsForSprites.GOAL, new Point2D(13, 14), true);
        board.fillBoard();
        board.fillEdges();

        obm.addObject(goal);

        for(Element boardObject : obm.getBoardObjects()) {
            if (boardObject instanceof Goal) {
                assert (boardObject.getPos() == goal.getPos());
            } else {
                assert (boardObject.getPos() != goal.getPos());
            }
        }
    }

//    @Test(timeout = 500)
//    public voic TestModify() {
//        Goal goal = new Goal(EnumsForSprites.GOAL, new Point2D(13, 14), true);
//        assert (goal.)
//    }



// <<<<<<< make_play_mode
//         Goal goal = new Goal(EnumsForSprites.GOAL, new Point2D(2, 2), true);
//         PlayerState playerState = new PlayerState();
// =======
//  /* TODO: Fix it
//         Goal goal = new Goal("goal", new Point2D(2, 2));
//         PlayerState playerState = new PlayerState(100, Point2D);

//         Goal goal = new Goal(EnumsForSprites.GOAL, new Point2D(2, 2));
//         PlayerState playerState = new PlayerState(100, Point2D(;

// >>>>>>> main
//         goal.changePlayerState(playerState);
//         assert (playerState.getWinningState());
//     }
//     */

}
