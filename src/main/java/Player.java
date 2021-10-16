public class Player {
    private int pos;
    private int points;
    private final String sprite;

    public Player(int pos, String sprite){
        this.pos = pos;
        this.points = 0;
        this.sprite = sprite;
    }

    public void makeMove(int move, Board board){
        this.pos = board.makeMove(move, this.pos);
    }

    public int getPos(){
        return pos;
    }

    public void setPoints(int p){
        points += p;
    }

    public int getPoints(){
        return points;
    }

    @Override
    public String toString() {
        return this.sprite;
    }
}
