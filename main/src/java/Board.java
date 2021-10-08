package java;

public class Board {
    private Seeder seeder; // creates randomized decorations for this Board.
    private int dimension;

    //add a default dimension Board.
    public Board (int dim, Seeder seeder){
        // seeder is a 2D Array[dim] that has been randomized. Iterate through seeder to seed the Board.
        this.seeder = seeder;
        this.dimension = dim;
        this.seed(seeder);
    }

    private Board seed(Seeder s) {
        //
    }

    public String check(int[] Pos) {
        //check what's at the position: out of boundary, blocked, deduct points, add points, or just a normal spot.
    }

}
