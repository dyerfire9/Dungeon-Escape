package elements;

import game.PlayerState;

public interface Interactable {
    PlayerState changePlayerState(PlayerState playerState);
}
