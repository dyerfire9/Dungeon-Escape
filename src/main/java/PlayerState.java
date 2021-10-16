public class PlayerState {
    private int points;

    public PlayerState(Player p){
        this.points = p.getPoints();
    }

    public int getStatePoints(){
        return this.points;
    }
}
