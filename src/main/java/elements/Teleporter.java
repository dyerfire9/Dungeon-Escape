package elements;
import game.PlayerState;
import utils.Point2D;

public class Teleporter extends Element implements Interactable{

    private Point2D teleportPoint;
    public Teleporter (String sprite, Point2D pos, Point2D teleportPoint) {
        super(sprite, pos);
        this.teleportPoint = teleportPoint;
    }


    @Override
    public PlayerState changePlayerState(PlayerState playerState) {
        playerState.setPos(this.teleportPoint);
        // To check if player actually stepping on portal is registered
        playerState.updatePoints(-1);
        return playerState;
    }

}