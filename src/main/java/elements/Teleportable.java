package elements;
import game.Player;
import game.PlayerState;
import utils.Point2D;

public interface Teleportable {
    PlayerState changePlayerPosition(PlayerState playerState, Point2D newPos);

}
