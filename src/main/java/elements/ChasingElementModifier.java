package elements;

import game.PlayerState;

import java.io.Serializable;

public class ChasingElementModifier extends Modifier implements Serializable {
    @Override
    public PlayerState Modifier(PlayerState playerState){
        if (!playerState.checkInvincible()) {
            playerState.updatePoints(-5);

            playerState.resetIframes();

        }
        return playerState;
    }
}
