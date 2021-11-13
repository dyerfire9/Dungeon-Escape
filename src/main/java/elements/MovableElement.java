package elements;

import utils.Point2D;


public class MovableElement extends Element implements Movable{
    private final int max_tick;
    private int counter;
    private final Point2D velocity;
    private final int bound;
    public MovableElement(String sprite, Point2D pos, int bound, int max_tick, Point2D velocity) {
        super(sprite, pos);
        this.bound = bound;
        this.velocity = velocity;
        this.max_tick = max_tick;
        this.counter = 0;
    }

    public boolean processTick() {
        if (counter < max_tick){
            counter += 1;
            return true;
        }
        else {
            this.counter = 0;
            return this.move();
        }
    }

    @Override
    public boolean move() {
        Point2D currPos = super.getPos();
        Point2D newPos = Point2D.add(currPos, this.velocity);


        if (newPos.getX() > this.bound || newPos.getY() > this.bound) {
            return false;
        }
        else {
            super.setPos(newPos);

            return true;
        }

    }
}
