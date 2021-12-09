package game;

import elements.modification.Modifier;
import elements.types.*;
import org.junit.*;
import utils.EnumsForSprites;
import utils.Point2D;
import utils.PointImagePair;

import java.beans.PropertyChangeEvent;
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
        om.addRightAlligatorDen(new Point2D(5,1));
        om.addLeftAlligatorDen(new Point2D(1,2));
        om.addDownAlligatorDen(new Point2D(2,1));
        om.addUpAlligatorDen(new Point2D(2,2));
        om.addGoal(new Point2D(3,1));
        om.addPortal(new Point2D(4,4));
        om.addRock(new Point2D(4,5));
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
        assert e.get(8) instanceof Goal;
        assert om.checkOverlap(point2D);
        om.removeObject(point2D);
        om.removeObject(e.get(5));
        om.addPortal(new Point2D(17,16));
        assert om.checkPortals();
        assert !om.checkOverlap(point2D);
        ObjectManager mo = new ObjectManager(e, 20);
        assert mo.checkPortals();
        PlayerState playerState = new PlayerState(100, new Point2D(3,2));
        mo.addGoal(new Point2D(12,12));
        ChasingElement chasingElement = new ChasingElement(EnumsForSprites.CHASER, new Point2D(13,13),4,
                2, new Point2D(1,0),false);
        mo.addObject(chasingElement);
        mo.updateObjects();
        ArrayList<Modifier> m = mo.modifyPlayerState(playerState);
        ArrayList<PointImagePair> k = mo.getPointImagePairs();
        mo.resetToBaseState();
    }

    @Test(timeout = 500)
    public void TestObjectAdditions() {
        int totalObjBeforeAdditions;
        int totalObjPostAdditions;

        Game game = new Game(15);
        Goal goal = new Goal(EnumsForSprites.GOAL, new Point2D(14, 13), true);
        Rock r = new Rock(EnumsForSprites.ROCK, new Point2D(12, 12), true);
        Portal portal = new Portal(EnumsForSprites.PORTAL, new Point2D(7,7), r.getPos(), true);
        ObjectManager objman = game.getObjectManager();

        objman.addDownAlligatorDen(new Point2D(7,5));
        objman.addRightAlligatorDen(new Point2D(2,7));
        totalObjBeforeAdditions = objman.getBoardObjects().size();

        objman.addObject(goal);
        objman.addObject(r);
        objman.addObject(portal);
        totalObjPostAdditions = objman.getBoardObjects().size();
        assert(totalObjBeforeAdditions != totalObjPostAdditions);

    }
}