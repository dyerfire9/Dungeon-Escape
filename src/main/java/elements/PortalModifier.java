package elements;

import game.PlayerState;
import utils.Point2D;

import java.io.Serializable;

public class PortalModifier extends Modifier implements Serializable {
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
