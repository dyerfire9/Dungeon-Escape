import java.util.ArrayList;

public class Board {
    private final int size;
    private final Tile[] board;

    // The board is one dimensional for now
    public Board (int size){
        this.size = size;
        this.board = generateBoard().toArray(new Tile[this.size]);
    }

    // TODO Maybe there's a way to make this cleaner
    public ArrayList<Tile> generateBoard() {
        ArrayList<Tile> board_list = new ArrayList<>();
        board_list.add(new Tile(false, "x"));
        for (int i = 1; i < this.size - 1; i ++) {
            board_list.add(new Tile(true, "o"));
        }
        board_list.add(new Tile(false, "x"));


        assert(this.size == board_list.size());

        return board_list;
    }
    public int makeMove(int move, int curr_position) {
        if (this.board[curr_position + move].isTraversable()) {
            return curr_position + move;
        }
        else {
            return curr_position;
        }
    }


    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder board_repr = new StringBuilder();
        for (Tile tile : this.board) {
            board_repr.append(tile.toString());
        }
        return board_repr.toString();

    }

}
