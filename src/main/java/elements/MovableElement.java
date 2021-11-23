package elements;

import utils.EnumsForSprites;
import utils.Point2D;


public class MovableElement extends Element implements Movable{
    private final int max_tick;
    private int counter;
    private final Point2D velocity;
    private final int bound;

    /**
     * A constructor for the MovableElement class.
     * @param sprite the element's representation
     * @param pos the element's initial position
     * @param bound the element's movement boundary
     * @param max_tick the number of frame ticks before the next movement
     * @param velocity the movement per tick, represented by a pair of integers on our tile-based game board.
     */
    public MovableElement(EnumsForSprites sprite, Point2D pos, int bound, int max_tick, Point2D velocity) {
        super(sprite, pos);
        this.bound = bound;
        this.velocity = velocity;
        this.max_tick = max_tick;
        this.counter = 0;
    }

    /**
     * An internal tick-counter to be linked to the frame ticks of the game.
     * When the internal counter reaches a preset max number, the element makes a move.
     * @return whether the element makes a move
     */
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

    /**
     * Checks whether the element can make a move to a new position on the board.
     * If the new position is within the boundary, the element moves to the new position.
     * @return whether the element has moved to a new position on the board
     */
    @Override
    public boolean move() {
        Point2D currPos = super.getPos();
        Point2D newPos = Point2D.add(currPos, this.velocity);


        if (((newPos.getX() > this.bound)|| (newPos.getX() < 0))  ||
                ((newPos.getY() > this.bound)|| (newPos.getY() < 0))) {
            return false;
        }
        else {
            super.setPos(newPos);

            return true;
        }

    }
}
