package elements;
import game.PlayerState;
import utils.EnumsForSprites;
import utils.Point2D;

public class Portal extends Element implements Interactable{

    private Point2D teleportPoint;
    private PortalModifier mod;
    public Portal(EnumsForSprites sprite, Point2D pos, Point2D teleportPoint) {
        super(sprite, pos);

        this.teleportPoint = teleportPoint;
        this.mod = new PortalModifier(teleportPoint);
    }

    public void changeTeleportPoint(Point2D pos) {
        this.teleportPoint = pos;
    }

    /**
     * Returns the Portal's modifier, to modify elsewhere
     * @param playerState the Player's current playerState
     * @return the Portal's modifier
     */
    @Override
    public PortalModifier Modify(PlayerState playerState) {
        return this.mod;
    }

}