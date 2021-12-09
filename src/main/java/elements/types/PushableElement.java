package elements.types;

import utils.EnumsForSprites;
import utils.Point2D;

public class PushableElement extends Element {
    private int bound;
    public PushableElement(EnumsForSprites sprite, Point2D pos, int bound) {
        super(sprite, pos, true);
        this.bound = bound;
    }

    /**
     * Checks whether an instance of the PushableElement is touching the Player on any of the 4 sides.
     * @param playerPos player's position on the game board
     * @return true if the PushableElement is right next to Player on the game board
     */
    public boolean onContact(Point2D playerPos) {
        return ((Math.abs(Point2D.xDistance(this.getPos(), playerPos)) == 0 && this.getPos().getY() == playerPos.getY()) || Math.abs(Point2D.yDistance(this.getPos(), playerPos)) == 0 && this.getPos().getX() == playerPos.getX());
    }

    /**
     * Checks whether the element can be pushed to a new position on the board.
     * If the new position is within the boundary, the element moves to the new position.
     * @return whether the element has moved to a new position on the board
     */
    @Override
    public void setPos(Point2D newPos) {
        if (((newPos.getX() > this.bound -1 )|| (newPos.getX() < 1))  ||
                ((newPos.getY() > this.bound -1 )|| (newPos.getY() < 1))) {
            System.out.println("Can't be pushed further!");
        }
        else {
            super.setPos(newPos);
        }
    }
}
