package java;

public class Board {
    private int dimension;
    private int[] board;

    //add a default dimension Board.
    public Board (int dim, int size){
        this.dimension = dim;
        this.board = new int[size];
    }

    public int[] getBoard() {
        return board;
    }

    public int getSize() {
        return board.length;
    }

    private Board seed(Seed s) {
        // board needs a SEED only, not an entire Seeder
    }

    public String check(int[] Pos) {
        //check what's at the position: out of boundary, blocked, deduct points, add points, or just a normal spot.
    }

}
