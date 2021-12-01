package game;

import elements.ChasingElement;
import utils.Point2D;

import java.beans.PropertyChangeEvent;

public class ChasingElementController extends ElementController {

    public ChasingElementController(ChasingElement e) {
        super(e);
    }

    /**
     * Method from the PropertyChangeListener Interface that watches and receives changes from the observable.
     * Overridden so that the ChasingElement changes its moving direction in relation to the new position of the Player everytime the Player moves.
     *
     * @param evt the change in the observable. It's sent as a generic object, but can be cast to a more specific type.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Point2D playerOldPos = (Point2D) evt.getOldValue();
        Point2D playerNewPos = (Point2D) evt.getNewValue();
        ChasingElement ce = (ChasingElement) this.getElement();

        int directionX = (int) (Math.signum(Point2D.xDistance(playerNewPos, ce.getPos())) * 1);
        int directionY = (int) (Math.signum(Point2D.yDistance(playerNewPos, ce.getPos())) * 1);

        Point2D newVel = new Point2D(directionX, directionY);
        ce.setVelocity(newVel);
    }
}
