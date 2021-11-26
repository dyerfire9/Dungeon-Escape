package elements;
import game.Player;
import game.PlayerState;
import utils.Point2D;

public class Teleporter extends Element implements Interactable, Teleportable{

    public Teleporter (String sprite, Point2D pos) {
        super(sprite, pos);
    }

    @Override
    public PlayerState changePlayerState(PlayerState playerState) {
        return playerState;
    }


}
