package utils;

public class PlayerState {
    int points;
    public PlayerState(int points) {
        this.points = points;
    }

    public void updatePoints(int change) {
        this.points += change;
    }
}
