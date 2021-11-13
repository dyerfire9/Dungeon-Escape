package elements;

import utils.PlayerState;
import utils.Point2D;

public class Goal extends Element implements Interactable {

    public Goal (String sprite, Point2D pos) {
        super(sprite, pos);
    }

    @Override
    public PlayerState changePlayerState (PlayerState playerState) {
        playerState.setWinningState(true);
        return playerState;
    }
}
