package elements;

import game.PlayerState;
import utils.Point2D;
import utils.EnumsForSprites;

public class Goal extends Element implements Interactable {

    /**
     * A constructor for the Goal class, inherited from its parent class Element.
     * @param sprite the element's representation
     * @param pos the element's initial position
     */
    public Goal (EnumsForSprites sprite, Point2D pos, boolean isPermanent) {
        super(sprite, pos, isPermanent);
    }

    /**
     * Changes a Player's PlayerState if encountered.
     * @param playerState the Player's current PlayerState
     * @return the updated PlayerState
     */
    @Override
    public PlayerState changePlayerState (PlayerState playerState) {
        playerState.setWinningState(true);
        return playerState;
    }
}
