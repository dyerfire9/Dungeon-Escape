package game;

import utils.Point2D;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class PlayerState implements Serializable {
    int points;
    int iFrames;
    boolean hasWon;
    Point2D oldPosition;
    Point2D playerPosition;
    Point2D movement;
    private final PropertyChangeSupport observable;

    /**
     * A constructor for the PlayerState class, which takes in an initial points and sets
     * its invincibility frame count to 60 and winning state to false.
     * @param points the PlayerState's current points
     */
    public PlayerState(int points, Point2D playerPos) {
        this.points = points;
        this.iFrames = 60;
        this.hasWon = false;
        this.oldPosition = playerPos;
        this.playerPosition = playerPos;
        this.movement = new Point2D(0,0);
        this.observable = new PropertyChangeSupport(this);
    }

    /**
     * Add a new observer to observe the changes to this class.
     * @param observer
     */
    public void addObserver(PropertyChangeListener observer) {
        observable.addPropertyChangeListener("location", observer);
    }


    /**
     * Updates the PlayerState's points by an increment
     * @param change the change increment
     */
    public void updatePoints(int change) {
        this.points += change;
    }

    /**
     * Checks whether the Player's invincibility frame count has decreased to 0.
     * If not, the Player's PlayerState cannot be changed.
     * @return whether the Player's invincibility frame count has decreased to 0.
     */
    public boolean checkInvincible() {
        return (iFrames > 0);
    }

    /**
     * Decreases the PlayerState's invincibility frame count by 1.
     */
    public void decrementIframes() {
        if (this.iFrames > 0) {
            this.iFrames -= 1;
        }
    }


    /**
     * Getters and (re)Setters for PlayerState's attributes.
     */

    /**
     * Sets this Player's location to newLocation and notifies its Observers.
     *
     * @param newPos This Player's new location.
     */
    public void setPos(Point2D newPos){

        Point2D oldPos = this.oldPosition;
        this.playerPosition = newPos;
        movement = new Point2D(newPos.getX() - oldPosition.getX(), newPos.getY() - oldPosition.getY());
        this.oldPosition = newPos;
        observable.firePropertyChange("location", oldPos, newPos);

//        this.oldPosition =this.getPos();
//        Point2D oldPos = this.getPos();
//        this.playerPosition = newPos;
//        observable.firePropertyChange("location", oldPos, newPos);
    }
    public Point2D getPos(){return this.playerPosition;}
    public void resetIframes() {this.iFrames = 60;}
    public int getPoints(){
        return points;
    }
    public int getiFrames() {
        return iFrames;
    }
    public void setWinningState(boolean hasWon) {this.hasWon = hasWon; }
    public boolean getWinningState() {return this.hasWon;}

    public Point2D getMovement(){
        return this.movement;
    }
}
