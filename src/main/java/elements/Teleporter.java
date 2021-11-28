package elements;
import game.PlayerState;
import utils.Point2D;

public class Teleporter extends Element implements Interactable{

    public Teleporter (String sprite, Point2D pos) {
        super(sprite, pos);
    }

    @Override
    public PlayerState changePlayerState(PlayerState playerState) {
        playerState.setPos(this.getPos());
        // To check if player stepping on portal is registered
        playerState.updatePoints(-1);
        return playerState;
    }
}