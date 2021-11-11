package elements;

import javafx.scene.image.Image;
import utils.Point2D;

public class AlligatorDen extends Generator{

    public AlligatorDen(Image sprite, Point2D pos, Point2D direction, int max_tick, int bound) {
        super(sprite, pos, direction, max_tick, bound);
    }

    @Override
    MovableElement generateElement(Point2D direction, int bound) {
        return new MovableElement(new Image("file:src/main/assets/player/animals/alligator.png"),
                super.getPos(), super.bound, 60, this.direction);
    }
}


