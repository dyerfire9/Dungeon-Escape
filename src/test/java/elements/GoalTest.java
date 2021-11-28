package elements;

import org.junit.Test;
import game.PlayerState;
import utils.Point2D;
import utils.EnumsForSprites;

public class GoalTest {
    @Test(timeout = 500)
    public void TestReachGoal() {
        Goal goal = new Goal(EnumsForSprites.GOAL, new Point2D(2, 2), true);
        PlayerState playerState = new PlayerState();
        goal.changePlayerState(playerState);
        assert (playerState.getWinningState());
    }
}
