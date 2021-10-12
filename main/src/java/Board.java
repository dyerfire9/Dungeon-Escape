package java;

import java.util.ArrayList;

public class Board {
    private int size;
    private Tile[] board;

    // add a default dimension Board.
    // The board is one dimensional for now
    public Board (int size){
        this.size = size;
        this.board = generateBoard().toArray(new Tile[this.size]);
    }

    public ArrayList<Tile> generateBoard() {
        ArrayList<Tile> board_list = new Arraylist<>;
        board_list.add(new Tile(false, "x"));
        for (i = 1; i < this.size - 2; i ++) {
            board_list.add(new Tile(true, "o"));
        }
        board_list.add(new Tile(false, "x"));

        return board_list;
    }


    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder board_repr = new StringBuilder();
        for (Tile i: this.board) {
            board_repr.append(i.toString());
        }
        return board_repr.toString();

    }

}
