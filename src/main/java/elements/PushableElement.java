package elements;

import utils.EnumsForSprites;
import utils.Point2D;

public class PushableElement extends Element implements Pushable{
    private int counter;

    /**
     * A constructor fo the Element class. This is the base class for all elements on the board.
     *  @param sprite the element's representation; currently set to String, but will be mapped to an
     *               image by the GraphicsLoader.
     * @param pos    the element's position on the board, represented by a pair of integer coordinates.
     */
    public PushableElement(EnumsForSprites sprite, Point2D pos) {
        super(sprite, pos);
        this.counter = counter;
    }

    @Override
    public boolean push() {

        Point2D currPos = super.getPos();
        Point2D newPos = super.getPos();



        return false;
    }
}
