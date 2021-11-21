package utils;

import elements.AlligatorDen;
import elements.MovableElement;
import org.junit.Test;

public class PointImagePairTest {
    @Test(timeout = 500)
    public void TestGetPoints() {

        PointImagePair pointImagePair = new PointImagePair(new Point2D(2 ,2), "test");

        Point2D point2D = pointImagePair.getPoint();

        assert (Point2D.equals(point2D, new Point2D(2, 2)));
    }
    @Test(timeout = 500)
    public void TestGetImage() {

        PointImagePair pointImagePair = new PointImagePair(new Point2D(2 ,2), "test");

        String image = pointImagePair.getImg();

        assert (image.equals("test"));
    }
}
