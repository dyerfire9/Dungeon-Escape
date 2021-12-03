package elements;

import game.PlayerState;

import java.io.Serializable;

public class GoalModifier extends Modifier implements Serializable {
    @Override
    public PlayerState Modifier(PlayerState playerState) {
        playerState.setWinningState(true);
        return playerState;
    }
}
