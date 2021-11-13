package elements;

import utils.PlayerState;
import utils.Point2D;

public class Alligator extends MovableElement implements Interactable{
    public Alligator(String sprite, Point2D pos, int bound, int max_tick, Point2D velocity) {
        super(sprite, pos, bound, max_tick, velocity);
    }

    @Override
    public PlayerState changePlayerState(PlayerState playerState) {
        if (!playerState.checkInvincible()) {
            playerState.updatePoints(-1);

            playerState.resetIframes();

        }
        return playerState;
    }
}
