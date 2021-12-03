package elements;

import game.PlayerState;

public class ChasingElementModifier extends Modifier{
    @Override
    public PlayerState Modifier(PlayerState playerState){
        if (!playerState.checkInvincible()) {
            playerState.updatePoints(-5);

            playerState.resetIframes();

        }
        return playerState;
    }
}
