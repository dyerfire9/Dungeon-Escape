package elements;

import org.junit.Test;
import game.PlayerState;
import utils.Point2D;

public class GoalTest {
    @Test(timeout = 500)
    public void TestReachGoal() {
        Goal goal = new Goal("goal", new Point2D(2, 2));
        PlayerState playerState = new PlayerState(100, Point2D);
        goal.changePlayerState(playerState);
        assert (playerState.getWinningState());
    }
}
