package elements;
import game.PlayerState;
import utils.Point2D;

public class Portal extends Element implements Interactable{

    private Point2D teleportPoint;
    public Portal(String sprite, Point2D pos, Point2D teleportPoint) {
        super(sprite, pos);

        this.teleportPoint = teleportPoint;
    }

    public void changeTeleportPoint(Point2D pos) {
        this.teleportPoint = pos;
    }
    @Override
    public PlayerState changePlayerState(PlayerState playerState) {
        playerState.setPos(this.teleportPoint);
        // To check if player actually stepping on portal is registered
        playerState.updatePoints(-1);
        return playerState;
    }

}