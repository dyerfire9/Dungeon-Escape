package elements;

import game.PlayerState;
import utils.Point2D;
import utils.EnumsForSprites;

public class Goal extends Element implements Interactable {

    private GoalModifier mod;

    /**
     * A constructor for the Goal class, inherited from its parent class Element.
     * @param sprite the element's representation
     * @param pos the element's initial position
     */
    public Goal (EnumsForSprites sprite, Point2D pos) {
        super(sprite, pos);
        this.mod = new GoalModifier();
    }

    /**
     * Changes a Player's PlayerState if encountered.
     * @param playerState the Player's current PlayerState
     * @return the updated PlayerState
     */
    @Override
    public GoalModifier Modify(PlayerState playerState) {
        return this.mod;
    }
}
