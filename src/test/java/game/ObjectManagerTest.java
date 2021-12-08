package game;

import elements.types.*;
import org.junit.*;
import utils.EnumsForSprites;
import utils.Point2D;

import java.util.ArrayList;

public class ObjectManagerTest {

    @Test(timeout = 500)
    public void TestgetImg() {
        ArrayList<Element> testArray = new ArrayList<>();
        Point2D pos = new Point2D(4, 5);
        Point2D velocity = new Point2D(0,2);
        Alligator a = new Alligator(EnumsForSprites.ALLIGATOR, pos, 50, 80, velocity, false);
        ObjectManager om = new ObjectManager(18);
        om.addObject(a);
        assert(om.getPointImagePairs().get(0).getImg().equals(EnumsForSprites.ALLIGATOR));
    }

    @Test(timeout = 500)
    public void TestgetPoint() {
        ArrayList<Element> testArray = new ArrayList<>();
        Point2D pos = new Point2D(4, 5);
        Point2D velocity = new Point2D(0,2);
        Alligator a = new Alligator(EnumsForSprites.ALLIGATOR, pos, 50, 80, velocity, false);
        ObjectManager om = new ObjectManager(18);
        om.addObject(a);
        assert(Point2D.equals(om.getPointImagePairs().get(0).getPoint(),new Point2D(4,5)));
    }

    @Test(timeout = 500)
    public void TestAddObject() {
        ObjectManager om = new ObjectManager(18);
        om.addChasingElement(new Point2D(3,2),1);
        om.addRightAlligatorDen(new Point2D(1,1));
        om.addLeftAlligatorDen(new Point2D(1,2));
        om.addDownAlligatorDen(new Point2D(2,1));
        om.addUpAlligatorDen(new Point2D(2,2));
        om.addGoal(new Point2D(3,1));
        om.addPortal(new Point2D(4,4));
        om.addRock(new Point2D(4,5));
        om.addPushable(new Point2D(5,5));
        Point2D point2D = new Point2D(7,7);
        om.addGoal(point2D);
        ArrayList<Element> e = om.getBoardObjects();
        assert e.get(0) instanceof ChasingElement;
        assert e.get(1) instanceof AlligatorDen;
        assert e.get(2) instanceof AlligatorDen;
        assert e.get(3) instanceof AlligatorDen;
        assert e.get(4) instanceof AlligatorDen;
        assert e.get(5) instanceof Goal;
        assert e.get(6) instanceof Portal;
        assert e.get(7) instanceof Rock;
        assert e.get(8) instanceof PushableElement;
        assert e.get(9) instanceof Goal;
        assert om.checkOverlap(point2D);
        om.removeObject(point2D);
        om.removeObject(e.get(5));
        assert e.get(7) instanceof PushableElement;
        assert om.checkPortals();
        assert !om.checkOverlap(point2D);
    }
}