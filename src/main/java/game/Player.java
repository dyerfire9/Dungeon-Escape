package game;
import utils.PlayerState;
import utils.Point2D;

import java.io.Serializable;

public class Player implements Serializable {
    private Point2D pos;
    public PlayerState playerState;
    private final String sprite;

    /**
     * A constructor for the Player class, which sets its position on the board, its PlayerState with an initial 100 points, and a representation.
     * @param pos the initial position of the Player
     */
    public Player(Point2D pos){
        this.pos= pos;
        this.playerState = new PlayerState(100);
        this.sprite =  "Player";
    }


    /**
     * Getters and Setters for Player attributes.
     */
    public Point2D getPos(){
        return pos;
    }
    public void setPos(Point2D newPos) { this.pos = newPos; }
    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }
    public String getSprite() {
        return this.sprite;
    }
    public PlayerState getPlayerState() {return this.playerState;}


    /**
     * A wrapper method that calls on the Player's PlayerState to decrease its invincibility-frame-count.
     */
    public void decrementIframes() {
        this.playerState.decrementIframes();
    }
}
