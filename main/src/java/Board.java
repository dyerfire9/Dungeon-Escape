package java;

public class Board {
    private int dimension;

    //add a default dimension Board.
    public Board (int dim, Seed seed){
        // seeder is a 1D Array[dim] that has been randomized. Iterate through seeder to seed the Board.
        this.seed = seeder;
        this.dimension = dim;
        this.seed(seeder);
    }

    private Board seed(Seed s) {
        // board needs a SEED only, not an entire Seeder
    }

    public String check(int[] Pos) {
        //check what's at the position: out of boundary, blocked, deduct points, add points, or just a normal spot.
    }

}
