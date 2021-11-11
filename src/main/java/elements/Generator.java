package elements;

import javafx.scene.image.Image;
import utils.Point2D;

public abstract class Generator extends Element {
    Point2D direction;
    int max_tick;
    int counter;
    int bound;
    public Generator(Image sprite, Point2D pos, Point2D direction, int max_tick, int bound) {
        super(sprite, pos);
        this.direction = direction;
        this.max_tick = max_tick;
        this.counter = 0;
        this.bound = bound;
    }

    abstract MovableElement generateElement(Point2D direction, int bound);

    public MovableElement placeElement() {
        if (counter < max_tick){
            counter += 1;
            return null;
        }
        else {
            this.counter = 0;
            MovableElement genElement = generateElement(direction, this.bound);
            genElement.setPos(Point2D.add(super.getPos(), direction));

            return genElement;
        }
    }
}

