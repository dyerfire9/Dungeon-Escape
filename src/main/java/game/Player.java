package game;
import utils.Point2D;

import java.io.Serializable;

public class Player implements Serializable {
    private Point2D pos;
    public PlayerState playerState;
    private final String sprite;

    /**
     * A constructor for the Player class, which sets its position on the board, its PlayerState with an initial 100
     * points, and a representation.
     * @param pos the initial position of the Player
     */
    public Player(Point2D pos){
        this.pos= pos;
        this.playerState = new PlayerState(100, this.pos);
        this.sprite =  "Player";
    }


    /** Gets the Player's current position.
     * @return the Player's current position, represented by a Point2D object composed of 2 integer coordinates
     */
    public Point2D getPos(){
        return pos;
    }

    /**
     * Sets the Player's position to a new position.
     * @param newPos the new position, represented by a Point2D object composed of 2 integer coordinates
     */
    public void setPos(Point2D newPos) { this.pos = newPos; }


    /**
     * Sets the Player's playerState.
     * @param playerState the new playerState
     */
    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }


    /**
     * Sets the Player's representation, currently a String and to be mapped to an Image by  the GraphicsLoader.
     * @return the Player's representation
     */
    public String getSprite() {
        return this.sprite;
    }


    /**
     * Gets the Player's playerState.
     * @return the Player's playerState
     */
    public PlayerState getPlayerState() {return this.playerState;}


    /**
     * A wrapper method that calls on the Player's PlayerState to decrease its invincibility-frame-count.
     */
    public void decrementIframes() {
        this.playerState.decrementIframes();
    }
}
