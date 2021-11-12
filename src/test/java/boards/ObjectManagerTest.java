package boards;

import elements.Element;
import javafx.scene.image.Image;
import org.junit.Test;
import utils.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class ObjectManagerTest {
    @Test(timeout = 50)
    public void TestUpdateObjects(){
        Point2D p = new Point2D(4,4);
        Point2D q = new Point2D(4,5);
        Element element = new Element(new Image("file:src/main/assets/player/animals/alligator.png"), p);
        Element e = new Element(new Image("file:src/main/assets/player/animals/alligator.png"), q);

    }

}