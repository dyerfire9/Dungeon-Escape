package elements.types;

import org.junit.Test;
import utils.EnumsForSprites;
import utils.Point2D;
import utils.PointImagePair;

import java.util.Objects;

public class ElementTest {

    @Test
    public void TestGetPointImagePair() {
        Point2D pos = new Point2D(3,3);
        Element element = new Element(EnumsForSprites.PUSHABLE, pos, true);
        PointImagePair result = element.getPointImagePair();
        System.out.println(result);
        assert(element.getPointImagePair().getPoint() == pos);
        assert(element.getPointImagePair().getImg() == EnumsForSprites.PUSHABLE);
    }

    @Test
    public void TestGetPos() {
        Point2D pos = new Point2D(3,3);
        Element element = new Element(EnumsForSprites.PUSHABLE, pos, true);
        assert(element.getPos() == pos);
    }

    @Test
    public void TestSetPos() {
        Point2D pos = new Point2D(3,3);
        Element element = new Element(EnumsForSprites.PUSHABLE, pos, true);
        assert(element.getPos() == pos);

        element.setPos(new Point2D(5,5));
        assert(element.getPos() != pos);
        assert(Point2D.equals(element.getPos(), new Point2D(5,5)));
    }

    @Test
    public void TestCheckIsPermanent() {
        Point2D pos = new Point2D(3,3);
        Element element = new Element(EnumsForSprites.PUSHABLE, pos, true);
        assert(element.checkIsPermanent());
    }
}
