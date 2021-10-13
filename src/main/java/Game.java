/**
 * Controls the system responsible for receiving player inputs and updating Board.
 */


public class Game {
    private Board board; // 1D array for now
    private Player player; //assuming 1 player for now.

    public Game() {
        this.board = new Board(10);
        this.player = new Player(5, "X");
    }

    public void makeMove(int move) {
        this.player.makeMove(move, this.board);
    }


    /**
     * Prints the current board state.
     * @return A string showing each tile of the board.
     */
    @Override
    public String toString() {
        String board_str = this.board.toString();

        return board_str.substring(0, this.player.getPos())
                + this.player.toString()
                + board_str.substring(this.player.getPos() + 1);
        }
    }
