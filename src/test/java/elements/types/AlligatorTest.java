package elements.types;

import elements.types.Alligator;
import org.junit.Test;
import game.PlayerState;
import utils.Point2D;
import utils.EnumsForSprites;

public class AlligatorTest {
        @Test(timeout = 500)
        public void TestAlligatorConstructor(){
        Alligator alligator = new Alligator(EnumsForSprites.ALLIGATOR, new Point2D(6, 5),
                20, 60, new Point2D(1, 0), false);
        Point2D point2D = new Point2D(2,2);
        PlayerState playerState = new PlayerState(100, point2D);
        assert alligator.Modify(playerState).Modifier(playerState).getPoints() == 100;
        }

}
