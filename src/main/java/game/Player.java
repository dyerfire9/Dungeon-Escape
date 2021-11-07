package game;

public class Player {
    private int[] pos;
    private int points;
    private final String sprite;

    public Player(int[] pos, String sprite){
        this.pos= pos;
        this.points = 100;
        this.sprite = sprite;
    }


    public int[] getPos(){
        return pos;
    }
    public void setPos(int[] newPos) { this.pos = newPos; }


    public void setPoints(int p){
        points += p;
    }
    public int getPoints(){
        return points;
    }
    public void changePoints(int change) {this.points += change;}

    @Override
    public String toString() {
        return this.sprite;
    }
}
