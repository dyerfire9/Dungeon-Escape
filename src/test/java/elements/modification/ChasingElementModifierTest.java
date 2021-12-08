package elements.modification;

import elements.types.Alligator;
import elements.types.ChasingElement;
import game.PlayerState;
import org.junit.*;
import utils.EnumsForSprites;
import utils.Point2D;

public class ChasingElementModifierTest {
    @Test(timeout = 500)
    public void TestChasingElementModifier(){
        ChasingElement chasingElement = new ChasingElement(EnumsForSprites.CHASER, new Point2D(6, 5),
                20, 60, new Point2D(1, 0), false);

        Point2D point2D = new Point2D(2,3);
        PlayerState playerState = new PlayerState(100, point2D);

        ChasingElementModifier modifiedPlayerstate =  chasingElement.Modify(playerState);
        assert (modifiedPlayerstate.Modifier(playerState).getPoints() == 100);
    }

    @Test(timeout = 500)
    public void TestAlligatorInteractionVulnerable() {
        ChasingElement chasingElement = new ChasingElement(EnumsForSprites.CHASER, new Point2D(6, 5),
                20, 60, new Point2D(1, 0), false);

        Point2D point2D = new Point2D(6,5);
        PlayerState playerState = new PlayerState(100, point2D);

        for (int i = 0; i <= 60; i ++) {
            playerState.decrementIframes();
        }

        ChasingElementModifier modifiedPlayerstate =  chasingElement.Modify(playerState);
        assert (modifiedPlayerstate.Modifier(playerState).getPoints() == 95);
    }

}