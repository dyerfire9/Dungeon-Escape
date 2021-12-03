package elements;

import game.PlayerState;

import java.io.Serializable;

public class AlligatorModifier extends Modifier implements Serializable {
    @Override
    public PlayerState Modifier(PlayerState playerState){
        if (!playerState.checkInvincible()) {
            playerState.updatePoints(-1);

            playerState.resetIframes();

        }
        return playerState;
    }
}
