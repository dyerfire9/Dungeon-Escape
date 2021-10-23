package Boards;

public class Board {
    private final int size;
    private Object[] board;


    // 1D linear representation of a 2D board.
    public Board(int size) {
        this.size = size;
        this.board = generateBoard();
    }

    public Object[] generateBoard() {
        Object[] boardList = new Object[(this.size + 1) * this.size];
        // Set up 4 edges:
        for (int i = 0; i < this.size; i++) {
            // top edge:
            boardList[i] = "x";
            // bottom edge:
            boardList[(this.size + 1) * (this.size - 1) + i] = "x";
            // left edge:
            boardList[i * (this.size + 1)] = "x";
            // right edge:
            boardList[(i + 1) * (this.size + 1) - 2] = "x";

        }
        return boardList;
    }


    public int getSize() {
        return this.size;
    }

    public Object[] getBoard() {
        return this.board;
    }

    public Object getElement(int pos){
        return this.board[pos];
    }
    public void setElement(int pos, Object element) {
        this.board[pos] = element;
    }

}

