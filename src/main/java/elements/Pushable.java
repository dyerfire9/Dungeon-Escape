package elements;

import game.PlayerState;
import utils.EnumsForSprites;
import utils.Point2D;

public class Pushable extends MovableElement implements Interactable, Movable{

    /**
     * A constructor for the MovableElement class.
     *
     * @param sprite   the element's representation
     * @param pos      the element's initial position
     * @param bound    the element's movement boundary
     * @param max_tick the number of frame ticks before the next movement
     * @param velocity the movement per tick, represented by a pair of integers on our tile-based game board.
     */
    public Pushable(EnumsForSprites sprite, Point2D pos, int bound, int max_tick, Point2D velocity) {
        super(sprite, pos, bound, max_tick, velocity);
    }


    @Override
    public PlayerState changePlayerState(PlayerState playerState) {
        // We have to discuss How many times the player can push the object in 60 frames.
        if (!playerState.checkInvincible()) {
            playerState.resetIframes();
        }
        return playerState;
    }
}
