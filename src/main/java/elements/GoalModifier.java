package elements;

import game.PlayerState;

public class GoalModifier extends Modifier{
    @Override
    public PlayerState Modifier(PlayerState playerState) {
        playerState.setWinningState(true);
        return playerState;
    }
}
