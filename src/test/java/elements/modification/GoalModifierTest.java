package elements.modification;

import elements.types.Alligator;
import elements.types.Goal;
import game.PlayerState;
import org.junit.Test;
import utils.EnumsForSprites;
import utils.Point2D;

public class GoalModifierTest {
    public void TestGoalModifier(){
        Goal goal = new Goal(EnumsForSprites.GOAL, new Point2D(6, 5),
                 true);

        Point2D point2D = new Point2D(2,3);
        PlayerState playerState = new PlayerState(100, point2D);

        GoalModifier modifiedPlayerstate =  goal.Modify(playerState);
        assert (modifiedPlayerstate.Modifier(playerState).getWinningState() == false);
    }

    @Test(timeout = 500)
    public void TestAlligatorInteractionVulnerable() {
        Goal goal = new Goal(EnumsForSprites.GOAL, new Point2D(6, 5),
                true);

        Point2D point2D = new Point2D(6, 5);
        PlayerState playerState = new PlayerState(100, point2D);

        GoalModifier modifiedPlayerstate = goal.Modify(playerState);
        assert (modifiedPlayerstate.Modifier(playerState).getWinningState() == true);
    }

}