package elements.types;

import elements.types.AlligatorDen;
import elements.types.MovableElement;
import org.junit.Test;
import utils.Point2D;
import utils.EnumsForSprites;

public class AlligatorDenTest {
    @Test(timeout = 500)
    public void TestAlligatorDenGenerate() {
        Point2D point2D = new Point2D(3,3);
        AlligatorDen alligatorDen = new AlligatorDen(EnumsForSprites.ALLIGATOR_DEN_RIGHT, point2D,
                new Point2D(1, 0), 60, 10, true);

        for (int i = 0; i <= 59; i++) {
            alligatorDen.placeElement();
        }
        MovableElement element = alligatorDen.placeElement();


        assert (!(element == null));
        assert alligatorDen.generateElement(point2D,4).getPos() == point2D;
    }
}
