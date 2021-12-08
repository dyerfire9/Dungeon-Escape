package elements.modification;

import game.PlayerState;

public interface Interactable {
    Modifier Modify(PlayerState playerState);
}
