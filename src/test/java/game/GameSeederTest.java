package game;

import org.junit.Test;
import utils.EnumsForSprites;
import utils.Point2D;

public class GameSeederTest {
    @Test(timeout = 500)
    public void TestGameSeeder(){
        GameSeeder om = new GameSeeder(new Game(20));
        om.addChasingElement(new Point2D(3,2),1);
        om.addRightAlligatorDen(new Point2D(1,1));
        om.addLeftAlligatorDen(new Point2D(1,2));
        om.addDownAlligatorDen(new Point2D(2,1));
        om.addUpAlligatorDen(new Point2D(2,2));
        om.addGoal(new Point2D(3,1));
        om.addPortal(new Point2D(4,4));
        om.addRock(new Point2D(4,5));
        om.addPushable(new Point2D(5,5));
        om.addPushable(new Point2D(5,6));
        om.addPushable(new Point2D(5,7));
        Point2D point2D = new Point2D(7,7);
        om.addGoal(point2D);
        om.add(EnumsForSprites.GOAL, new Point2D(9,1));
        om.add(EnumsForSprites.ALLIGATOR_DEN_UP, new Point2D(9,2));
        om.add(EnumsForSprites.ALLIGATOR_DEN_DOWN, new Point2D(9,3));
        om.add(EnumsForSprites.ALLIGATOR_DEN_LEFT, new Point2D(9,4));
        om.add(EnumsForSprites.ALLIGATOR_DEN_RIGHT, new Point2D(9,5));
        om.add(EnumsForSprites.PORTAL, new Point2D(9,6));
        om.add(EnumsForSprites.ROCK, new Point2D(9,7));
        om.add(EnumsForSprites.CHASER, new Point2D(9,8));
        om.add(EnumsForSprites.IS_TRAVERSABLE, new Point2D(9,10));
    }

}