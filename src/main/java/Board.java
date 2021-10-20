import java.util.ArrayList;

public class Board {
    private final int size;
    private final Tile[] board;

    // add a default dimension Board.
    // The board is one dimensional for now
    public Board (int size){
        this.size = size;
        this.board = generateBoard().toArray(new Tile[this.size]);
    }

    public ArrayList<Tile> generateBoard() {
        ArrayList<Tile> boardList= new ArrayList<>();
        boardList.add(new Tile(false, "x"));
        for (int i = 1; i < this.size - 1; i ++) {
            boardList.add(new Tile(true, "o"));
        }
        boardList.add(new Tile(false, "x"));

        return boardList;
    }
    public int makeMove(int move, int currPosition) {
        if (this.board[currPosition + move].isTraversable()) {
            return currPosition + move;
        }
        else {
            return currPosition;
        }
    }


    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder boardRepr = new StringBuilder();
        for (Tile tile : this.board) {
            boardRepr.append(tile.toString());
        }
        return boardRepr.toString();

    }

}
