package elements;

import utils.Point2D;

public class AlligatorDen extends Generator{

    public AlligatorDen(String sprite, Point2D pos, Point2D direction, int max_tick, int bound) {
        super(sprite, pos, direction, max_tick, bound);
    }

    @Override
    MovableElement generateElement(Point2D direction, int bound) {
        return new Alligator("alligator",
                super.getPos(), super.bound, 60, this.direction);
    }
}


