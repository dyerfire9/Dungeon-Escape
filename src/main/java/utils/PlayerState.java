package utils;

public class PlayerState {
    int points;
    int iFrames;
    public PlayerState(int points) {
        this.points = points;
        this.iFrames = 60;
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
}
