package elements;

import game.PlayerState;
import utils.EnumsForSprites;
import utils.Point2D;

public class Alligator extends MovableElement implements Interactable{
    /**
     * A constructor for the Alligator class, inherited from its parent class MovableElement.
     * @param sprite the element's representation
     * @param pos element's initial position
     * @param bound the movement boundary of this element.
     * @param max_tick number of frame ticks it takes for the next movement to happen
     * @param velocity the movement per tick, represented by a pair of integers on our tile-based game board.
     */
    public Alligator(EnumsForSprites sprite, Point2D pos, int bound, int max_tick, Point2D velocity) {
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
            playerState.updatePoints(-1);

            playerState.resetIframes();

        }
        return playerState;
    }
}
