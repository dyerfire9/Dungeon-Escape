package elements.types;

import org.junit.Test;
import utils.EnumsForSprites;
import utils.Point2D;

public class MovableElementTest {
    Point2D point2D = new Point2D(1,0);
    MovableElement movableElement = new MovableElement(EnumsForSprites.ALLIGATOR, new Point2D(3,3),14,
            1, point2D,false);

    @Test(timeout = 500)
    public void TestMovableElement(){
        assert movableElement.getVelocity() == point2D;
        Point2D point2D1 = new Point2D(0,1);
        movableElement.setVelocity(point2D1);
        assert movableElement.getVelocity() == point2D1;
        movableElement.move();
        assert movableElement.getPos().getY() == 4;
        assert movableElement.processTick();
        assert movableElement.processTick() == true;
        movableElement.reset();
        assert movableElement.getPos().getY() == 3;
        assert movableElement.getVelocity() == point2D;

    }

}