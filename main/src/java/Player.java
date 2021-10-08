package java;

public class Player {
    private int[] pos;
    private int points;

    public Player(){
        this.pos = // center of board?;
        this.points = 0;
    }

    public void makeMove(int[] move){
        // change pos;
    }

    public int[] getPos(){
        return pos;
    }

    public void pointsSetter(int p){
        points += p;
    }

    public int pointsGetter(){
        return points;
    }
}
