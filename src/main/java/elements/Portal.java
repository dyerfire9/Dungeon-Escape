package elements;
import game.PlayerState;
import utils.EnumsForSprites;
import utils.Point2D;

public class Portal extends Element implements Interactable{

    private Point2D teleportPoint;

    /**
     * A constructor for the Portal class, inherited from its parent the Element class.
     * @param sprite the element's representation
     * @param pos the element's initial position
     * @param teleportPoint The portal's teleporation coordinates
     */
    public Portal(EnumsForSprites sprite, Point2D pos, Point2D teleportPoint) {
        super(sprite, pos);

        this.teleportPoint = teleportPoint;
    }

    /**
     * Changes Portal's teleportation coordinates
     * @param pos the new teleporation coordinates
     */
    public void changeTeleportPoint(Point2D pos) {
        this.teleportPoint = pos;
    }

    /**
     * Changes a Player's PlayerState if encountered.
     * @param playerState the Player's current PlayerState
     * @return The updated PlayerState
     */
    @Override
    public PlayerState changePlayerState(PlayerState playerState) {
        playerState.setPos(this.teleportPoint);
        // To check if player actually stepping on portal is registered
        playerState.updatePoints(-1);
        return playerState;
    }

}