package elements;

import game.PlayerState;
import utils.Point2D;

public class PortalModifier extends Modifier{
    private Point2D teleportPoint;

    public PortalModifier(Point2D point){
        this.teleportPoint = point;
    }

    @Override
    public PlayerState Modifier(PlayerState playerState){
        playerState.setPos(this.teleportPoint);
        // To check if player actually stepping on portal is registered
        playerState.updatePoints(-1);
        return playerState;
    }
}
