package elements.modification;

import elements.types.Alligator;
import org.junit.Test;
import game.PlayerState;
import utils.Point2D;
import utils.EnumsForSprites;

public class AlligatorModifierTest {
    @Test(timeout = 500)
    public void TestAlligatorModifier(){
        Alligator alligator = new Alligator(EnumsForSprites.ALLIGATOR, new Point2D(6, 5),
                20, 60, new Point2D(1, 0), false);

        Point2D point2D = new Point2D(2,3);
        PlayerState playerState = new PlayerState(100, point2D);

        AlligatorModifier modifiedPlayerstate =  alligator.Modify(playerState);
        assert (modifiedPlayerstate.Modifier(playerState).getPoints() == 100);
    }

    @Test(timeout = 500)
    public void TestAlligatorInteractionVulnerable() {
        Alligator alligator = new Alligator(EnumsForSprites.ALLIGATOR, new Point2D(6, 5),
                20, 60, new Point2D(1, 0), false);

        Point2D point2D = new Point2D(6,5);
        PlayerState playerState = new PlayerState(100, point2D);

        for (int i = 0; i <= 60; i ++) {
            playerState.decrementIframes();
        }

        AlligatorModifier modifiedPlayerstate =  alligator.Modify(playerState);
        assert (modifiedPlayerstate.Modifier(playerState).getPoints() == 99);
    }

}