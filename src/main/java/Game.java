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

    // Getters
    public boolean getRunning(){return this.isRunning; }
    public void setRunning(boolean isRunning) {this.isRunning = isRunning; }

    public int getPlayerPosition() {return this.player.getPos();}
    public String getPlayerString() {return this.player.toString();}
    public String getBoardString() {return this.board.toString();}
    }
