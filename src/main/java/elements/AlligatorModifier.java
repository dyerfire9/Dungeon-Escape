package elements;

import game.PlayerState;

public class AlligatorModifier extends Modifier{
    @Override
    public PlayerState Modifier(PlayerState playerState){
        if (!playerState.checkInvincible()) {
            playerState.updatePoints(-1);

            playerState.resetIframes();

        }
        return playerState;
    }
}
