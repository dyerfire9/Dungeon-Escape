package elements;
import game.PlayerState;
import utils.Point2D;

public class Teleporter extends Element implements Teleportable{

    public Teleporter (String sprite, Point2D pos) {
        super(sprite, pos);
    }

//    @Override
//    public PlayerState changePlayerState(PlayerState playerState) {
//        playerState.setPos(this.getPos());
//        playerState.updatePoints(-1);
//        return playerState;
//    }

    @Override
    public PlayerState changePlayerPosition(PlayerState playerState, Point2D newPos) {
        playerState.setPos(newPos);
        // To check if player actually stepping on portal is registered
        playerState.updatePoints(-1);
        return playerState;
    }
}