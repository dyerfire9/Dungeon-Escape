package boards;

import elements.Element;

public class Board {
    private final int size;
    private Object[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new Object[size][size];
    }

    public int getSize() {
        return this.size;
    }

    public Object[][] getBoard() {
        return this.board;
    }

    public Object getElement(int[] pos) {
        return this.board[pos[0]][pos[1]];
    }

    public void setElement(int[] pos, Element e) {
        this.board[pos[0]][pos[1]] = e;
    }
}

