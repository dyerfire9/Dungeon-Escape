package elements;

import utils.EnumsForSprites;
import utils.Point2D;

public class PushableElement extends Generator {

    /**
     * A constructor for the MovableElement class.
     *
     * @param sprite   the element's representation
     * @param pos      the element's initial position
     * @param bound    the element's movement boundary
     * @param max_tick the number of frame ticks before the next movement
     */
    public PushableElement(EnumsForSprites sprite, Point2D pos, Point2D direction, int max_tick, int bound) {
        super(sprite, pos, direction, max_tick, bound);
    }


    @Override
    MovableElement generateElement(Point2D direction, int bound) {
        return new Pushable(EnumsForSprites.PUSHABLE,
                super.getPos(), super.bound, 30, this.direction);
    }
}
