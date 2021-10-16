/**
 * Controls the system responsible for receiving player inputs and updating Board.
 */


public class Game {
    private Board board; // 1D array for now
    private Player player; //assuming 1 player for now.
    private boolean isRunning = true;

    public Game() {
        this.board = new Board(10);
        this.player = new Player(5, "P");
    }

    public void makeMove(int move) {
        this.player.makeMove(move, this.board);
    }

    public Player getPlayer() {return this.player; }
    public void setPlayer(Player... pList) {
        //TODO: have multiple players on the same board;
    }

    public boolean getRunning(){return this.isRunning; }
    public void setRunning(boolean isRunning) {this.isRunning = isRunning; }

    /**
     * Prints the current board state.
     * @return A string showing each tile of the board.
     */
    @Override
    public String toString() {
        String boardStr = this.board.toString();

        return boardStr.substring(0, this.player.getPos())
                + this.player.toString()
                + boardStr.substring(this.player.getPos() + 1);
        }
    }
