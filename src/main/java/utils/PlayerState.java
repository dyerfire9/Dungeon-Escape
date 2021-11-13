package utils;

public class PlayerState {
    int points;
    int iFrames;
    boolean hasWon;

    public PlayerState(int points) {
        this.points = points;
        this.iFrames = 60;
        this.hasWon = false;
    }

    public void updatePoints(int change) {
        this.points += change;
    }

    public boolean checkInvincible() {
        return (iFrames > 0);
    }
    public void decrementIframes() {
        if (this.iFrames > 0) {
            this.iFrames -= 1;
        }
    }
    public void resetIframes() {
        this.iFrames = 60;
    }
    public int getPoints(){
        return points;
    }
    public int getiFrames() {
        return iFrames;
    }
    public void setWinningState(boolean hasWon) {this.hasWon = hasWon; }
    public boolean getWinningState() {return this.hasWon;}
}
