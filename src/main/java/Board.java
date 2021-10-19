import java.util.ArrayList;

public class Board {
    private final int size;
    private final Tile[][] board;

    // 2D Board
    public Board (int size){
        this.size = size;
        this.board = generateBoard();
    }

    // TODO: is it better to use 2D ArrayList?
    public Tile[][] generateBoard() {
        Tile[][] boardList = new Tile[this.size][this.size];
        for ( int j = 0; j < this.size; j ++) {
            boardList[0][j]= new Tile(false, "x");
            boardList[this.size-1][j]= new Tile(false, "x");
        }
        for (int i = 1; i < this.size -1; i ++) {
            boardList[i][0] = new Tile(false, "x");
            for (int j = 1; j < this.size - 1; j ++) {
                boardList[i][j] = new Tile(true, "o");
            }
            boardList[i][this.size-1] = new Tile(false, "x");
        }
        return boardList;
    }

    public int[] makeMove(int[] move, int[] currPosition) {
        int[] newPosition = {move[0] + currPosition[0], move[1] + currPosition[1]};

        if (this.board[newPosition[0]][newPosition[1]].isTraversable()) {
            return newPosition;
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
        for (int i = 0; i < this.size; i ++) {
            for (Tile tile : this.board[i]) {
                boardRepr.append(tile.toString());
            }
            boardRepr.append("\n");
        }
        return boardRepr.toString();
    }

}
