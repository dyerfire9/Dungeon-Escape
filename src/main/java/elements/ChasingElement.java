package elements;

import game.PlayerState;
import utils.EnumsForSprites;
import utils.Point2D;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


public class ChasingElement extends MovableElement implements Interactable, PropertyChangeListener {

    /**
     * A constructor for the MovableElement class.
     *
     * @param sprite   the element's representation
     * @param pos      the element's initial position
     * @param bound    the element's movement boundary
     * @param max_tick the number of frame ticks before the next movement
     * @param velocity the movement per tick, represented by a pair of integers on our tile-based game board.
     */
    public ChasingElement(EnumsForSprites sprite, Point2D pos, int bound, int max_tick, Point2D velocity) {
        super(sprite, pos, bound, max_tick, velocity);
    }


    /**
     * Defines the effect of this element on the Player if encountered.
     * @param playerState the Player's current playerState
     * @return the new playerState after this encounter.
     */
    @Override
    public PlayerState changePlayerState(PlayerState playerState) {
        if (!playerState.checkInvincible()) {
            playerState.updatePoints(-5);

            playerState.resetIframes();

        }
        return playerState;
    }


    /**
     * Method from the PropertyChangeListener Interface that watches and receives changes from the observable.
     * Overridden so that the ChasingElement changes its moving direction in relation to the new position of the Player everytime the Player moves.
     * @param evt the change in the observable. It's sent as a generic object, but can be cast to a more specific type.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Point2D playerOldPos = (Point2D) evt.getOldValue();
        Point2D playerNewPos = (Point2D) evt.getNewValue();

        /*//if (Point2D.linearDistance(this.getPos(), playerOldPos) <= 5){

            double velX = (Point2D.xDistance(this.getPos(), playerNewPos)/Point2D.linearDistance(this.getPos(), playerNewPos));
            double velY = (Point2D.yDistance(this.getPos(), playerNewPos)/Point2D.linearDistance(this.getPos(), playerNewPos));*/

            int directionX = (int) (Math.signum(Point2D.xDistance(playerNewPos, this.getPos())) * 1);
            int directionY = (int) (Math.signum(Point2D.yDistance(playerNewPos, this.getPos())) * 1);

            Point2D newVel = new Point2D(directionX, directionY);
            this.setVelocity(newVel);
        //}

        /*System.out.println("Chaser Observed a change in " +
                evt.getPropertyName() + " of " + evt.getSource());

        System.out.println(
                evt.getOldValue() + " has changed to " + evt.getNewValue() + ". ");
        System.out.println(
                "Chaser's velocity has changed to " + this.getVelocity() + ". ");

        System.out.println();*/
    }
}
