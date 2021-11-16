package boards;

import game.ObjectManager;
import elements.Alligator;
import elements.Element;
import org.junit.jupiter.api.Test;
import utils.Point2D;

import java.util.ArrayList;


class ObjectManagerTest {

    @Test
    void getImg() {
        ArrayList<Element> testArray = new ArrayList<>();
        Point2D pos = new Point2D(4, 5);
        Point2D velocity = new Point2D(0,2);
        Alligator a = new Alligator("all", pos, 50, 80, velocity);
        ObjectManager om = new ObjectManager(18);
        om.addObject(a);
        assert(om.getPointImagePairs().get(0).getImg().equals("all"));
    }

    @Test
    void getPoint() {
        ArrayList<Element> testArray = new ArrayList<>();
        Point2D pos = new Point2D(4, 5);
        Point2D velocity = new Point2D(0,2);
        Alligator a = new Alligator("all", pos, 50, 80, velocity);
        ObjectManager om = new ObjectManager(18);
        om.addObject(a);
        assert(Point2D.equals(om.getPointImagePairs().get(0).getPoint(),new Point2D(4,5)));
    }


}